package com.sandbox.console.json;

import com.aio.portable.swiss.global.Constant;
import com.aio.portable.swiss.sugar.StringSugar;
import com.aio.portable.swiss.suite.bean.serializer.ISerializerSelector;
import com.aio.portable.swiss.suite.bean.serializer.SerializerEnum;
import com.aio.portable.swiss.suite.bean.serializer.SerializerSelector;
import com.aio.portable.swiss.suite.bean.serializer.json.JacksonSugar;
import com.aio.portable.swiss.suite.io.NIOFiles;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//public class JsonCache {
//    private static String DEFAULT_DATABASE = "default";
//
//    private static Path DEFAULT_ROOT = Paths.get(Constant.CURRENT_DIRECTORY);
//
//
//    private Path root;
//
//    private String database = "_cache";
//
//    private static JsonCache instance;
//
//    private static String CACHE_EXTENSION = "cache";
//
//    private Charset charset = StandardCharsets.UTF_8;
//
//    protected ISerializerSelector serializer = new SerializerSelector(SerializerEnum.SERIALIZE_JACKSON_FORCE);
//
//
//    public final static JsonCache singletonInstance(Path root, String database) {
//        return instance = instance == null ? new JsonCache(root, database) : instance;
//    }
//
//    public final static JsonCache singletonInstance(String database) {
//        return instance = instance == null ? new JsonCache(DEFAULT_ROOT, database) : instance;
//    }
//
//    public final static JsonCache singletonInstance() {
//        return instance = instance == null ? new JsonCache(DEFAULT_ROOT, DEFAULT_DATABASE) : instance;
//    }
//
//    public JsonCache(Path root, String database) {
//        this.root = root;
//        this.database = database;
//    }
//
//    public JsonCache(String database) {
//        this.database = database;
//    }
//
//    public JsonCache() {
//    }
//
//    public void save(String table, String key, Object value) {
//        Path dirPath = Paths.get(root.toString(), database, table);
//        NIOFiles.createDirectories(dirPath);
//
//        String filename = MessageFormat.format("{0}.{1}", key, CACHE_EXTENSION);
//        Path path = Paths.get(root.toString(), database, table, filename);
////        String content = serializer.serialize(value);
//        String content = JacksonSugar.obj2Json(value);
//        NIOFiles.write(path, charset, content, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
//    }
//
//    public void remove(String table, String key) {
//        String filename = MessageFormat.format("{0}.{1}", key, CACHE_EXTENSION);
//        Path path = Paths.get(root.toString(), database, table, filename);
//        try {
//            Files.delete(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void removeTable(String table) {
//        Path path = Paths.get(root.toString(), database, table);
//        try {
//            Files.delete(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void removeDatabase() {
//        Path path = Paths.get(root.toString(), database);
//        try {
//            Files.delete(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    public <T> T get(String table, String key, Class<T> clazz) {
//        String filename = MessageFormat.format("{0}.{1}", key, CACHE_EXTENSION);
//        Path path = Paths.get(root.toString(), database, table, filename);
//        String content = NIOFiles.read(path, charset);
//        T t = JacksonSugar.json2T(content, clazz);
//        return t;
//    }
//
//    public <T> T get(String table, String key, TypeReference<T> valueTypeRef) {
//        String filename = MessageFormat.format("{0}.{1}", key, CACHE_EXTENSION);
//        Path path = Paths.get(root.toString(), database, table, filename);
//        String content = NIOFiles.read(path, charset);
//        T t = JacksonSugar.json2T(content, valueTypeRef);
//        return t;
//    }
//
//    public boolean exist(String table, String key) {
//        String filename = MessageFormat.format("{0}.{1}", key, CACHE_EXTENSION);
//        Path path = Paths.get(root.toString(), database, table, filename);
//        boolean exists = Files.exists(path);
//        return exists;
//    }
//
//    public List<String> keys(String table) {
//        Path path = Paths.get(root.toString(), database, table);
//        final List<Path> files = new ArrayList<>();
//
//        try {
//            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
////                    return super.visitFile(file, attrs);
//                    if (!attrs.isDirectory()) {
//                        files.add(file);
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        List<String> keys = files.stream().map(c -> StringSugar.removeEnd(c.getFileName().toString(), "." + CACHE_EXTENSION)).collect(Collectors.toList());
//        return keys;
//    }
//
//    public List<String> tables() {
//        Path path = Paths.get(root.toString(), database);
//        final List<Path> paths = new ArrayList<>();
//
//        try {
//            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
////                    return super.preVisitDirectory(dir, attrs);
//                    if (attrs.isDirectory() && !Objects.equals(dir, path)) {
//                        paths.add(dir);
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        List<String> keys = paths.stream().map(c -> c.getFileName().toString()).collect(Collectors.toList());
//        return keys;
//    }
//
//
//    public final static void save(String database, String table, String key, Object value) {
//        JsonCache jsonCache = JsonCache.singletonInstance(database);
//        jsonCache.save(table, key, value);
//    }
//
//    public final static void remove(String database, String table, String key) {
//        JsonCache jsonCache = JsonCache.singletonInstance(database);
//        jsonCache.remove(table, key);
//    }
//
//    public final static void removeTable(String database, String table) {
//        JsonCache jsonCache = JsonCache.singletonInstance(database);
//        jsonCache.removeTable(table);
//    }
//
//    public final static void removeDatabase(String database) {
//        JsonCache jsonCache = JsonCache.singletonInstance(database);
//        jsonCache.removeDatabase(database);
//    }
//
//    public final static <T> T get(String database, String table, String key, Class<T> clazz) {
//        JsonCache jsonCache = JsonCache.singletonInstance(database);
//        return jsonCache.get(table, key, clazz);
//    }
//
//    public final static <T> T get(String database, String table, String key, TypeReference<T> valueTypeRef) {
//        JsonCache jsonCache = JsonCache.singletonInstance(database);
//        return jsonCache.get(table, key, valueTypeRef);
//    }
//
//    public final static boolean exist(String database, String table, String key) {
//        JsonCache jsonCache = JsonCache.singletonInstance(database);
//        return jsonCache.exist(table, key);
//    }
//
//    public final static List<String> tables(String database) {
//        JsonCache jsonCache = JsonCache.singletonInstance(database);
//        return jsonCache.tables();
//    }
//
//    public final static List<String> keys(String database, String table) {
//        JsonCache jsonCache = JsonCache.singletonInstance(database);
//        return jsonCache.keys(table);
//    }
//}
