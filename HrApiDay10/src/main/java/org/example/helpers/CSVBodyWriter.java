package org.example.helpers;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;

@Provider
public class CSVBodyWriter implements MessageBodyWriter {
    @Override
    public boolean isWriteable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public void writeTo(Object o, Class type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {

        if (o instanceof ArrayList) {
            ArrayList items = (ArrayList) o;
            for (Object itemObj : items) {
                String row = createCsvRow(itemObj);
                entityStream.write(row.concat("\n").getBytes());
            }
        }
        else {
            String row = createCsvRow(o);
            entityStream.write(row.concat("\n").getBytes());
        }
    }

    private static String createCsvRow(Object o) {
        String row = "";
        Field[] fields = o.getClass().getDeclaredFields();

        for (Field f : fields) {
            if (f.getName().equals("links")) continue;

            f.setAccessible(true);
            try {
                String fieldValue = f.get(o).toString();
                row += fieldValue + ",";
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        return row;
    }
}
