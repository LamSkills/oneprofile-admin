package com.newlight77.admin.data.csv;

import com.newlight77.admin.neo4j.RightEntity;
import com.newlight77.admin.neo4j.RoleEntity;
import com.newlight77.admin.neo4j.UserEntity;
import com.newlight77.right.model.Right;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema;
import scala.collection.JavaConverters;
import scala.collection.Set;
import scala.collection.mutable.WrappedArray;

import java.util.stream.Collectors;

public class SparkUserMapper implements MapFunction<Row, UserEntity> {

    @Override
    public UserEntity call(Row row) {
        Set<Object> roleSet = ((WrappedArray<Object>) row.getAs("roles")).toSet();
        java.util.Set<RoleEntity> roles = roles(roleSet);
        return UserEntity.builder()
                .lastname(((String) row.getAs("lastname")).trim())
                .firstname(((String) row.getAs("firstname")).trim())
                .username(((String) row.getAs("username")).trim())
                .roles(roles)
                .build();
    }

    private java.util.Set<RoleEntity> roles(Set<Object> roleSet) {
        return JavaConverters.setAsJavaSetConverter(roleSet)
                .asJava()
                .stream()
                .map(r -> {
                    Row role = (GenericRowWithSchema) r;
                    String name = (role).getAs("name");
                    Set<Object> rightSet = ((WrappedArray<Object>) (role).getAs("rights")).toSet();
                    java.util.Set<RightEntity> rights = rights(rightSet);
                    return RoleEntity.builder().name(name.trim()).rights(rights).build();
                })
                .collect(Collectors.toSet());
    }

    private java.util.Set<RightEntity> rights(Set<Object> set) {
        return JavaConverters.setAsJavaSetConverter(set)
                .asJava()
                .stream()
                .map(r -> {
                    Row row = (GenericRowWithSchema) r;
                    String primary = row.getAs("primary");
                    String secondary = row.getAs("secondary");
                    Set<Object> rightSet = ((WrappedArray<Object>) row.getAs("rights")).toSet();
                    java.util.Set<Right> rights = JavaConverters.setAsJavaSetConverter(rightSet).asJava()
                            .stream().map(right -> Right.value(right.toString())).collect(Collectors.toSet());
                    return RightEntity.builder().primary(primary.trim()).secondary(secondary.trim()).rights(rights).build();
                })
                .collect(Collectors.toSet());
    }

}
