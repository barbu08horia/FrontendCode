package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import javax.lang.model.type.TypeKind;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lion King on 07-Jul-16.
 */
public class EntityUtils {
    private EntityUtils() {
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity) throws NoSuchFieldException {
        Table t = (Table) entity.getAnnotation(Table.class);
        if (t != null) {
            return t.name();
        } else {
            return entity.getSimpleName();
        }
    }

    public static List<ColumnInfo> getColumns(Class entity) {
        List<ColumnInfo> Lista = new ArrayList<>();
        Field[] campuri = entity.getDeclaredFields();
        for (Field f : campuri) {
            ColumnInfo ci = new ColumnInfo();
            ci.setColumnType(f.getType());
            ci.setColumnName(f.getName());

            Column c = f.getAnnotation(Column.class);
            Id i = f.getAnnotation(Id.class);
            if (c == null) {
                ci.setId(true);
                ci.setDbName(i.name());

            } else {
                ci.setId(false);
                ci.setDbName(c.name());
            }
            Lista.add(ci);
        }
        return Lista;
    }

    public static Object castFromSqlType(Object value, Class wantedType) {
        if (value.getClass().equals(BigDecimal.class)) {
            if (wantedType.getClass().equals(Integer.class)) {
                return (Integer) value;
            }
            if (wantedType.getClass().equals(Long.class)) {
                return (Long) value;
            }
            if (wantedType.getClass().equals(Float.class)) {
                return (Float) value;
            }
            if (wantedType.getClass().equals(Double.class)) {
                return (Double) value;
            }

        }

        return value;
    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation) {
        List<Field> campuri = new ArrayList<Field>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotation(annotation) != null)
                campuri.add(field);
        }
        return campuri;

    }

    public static Object getSqlValue(Object object) {
        if (object.getClass().getAnnotation(Table.class) != null) {
            Id id = object.getClass().getAnnotation(Id.class);
            Field[] f = object.getClass().getDeclaredFields();
            for (Field ff : f)
                if (ff.getAnnotation(Id.class) != null) {

                    ff.setAccessible(true);
                    return object;
                }
        }
        return object;
    }
}




























