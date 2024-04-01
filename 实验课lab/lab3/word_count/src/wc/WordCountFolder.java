package wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordCountFolder {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Map<String, Integer> wordMap = new TreeMap<>();
        File folder = new File("E:\\桌面\\mapreduce\\hadoop"); // 设置文件夹路径
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    processFile(file, wordMap);
                }
            }
        }
        long end = System.currentTimeMillis();
        Set<String> words = wordMap.keySet();
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            Integer count = wordMap.get(word);
            System.out.println("单词 " + word + ": " + count);
        }

        System.out.println("程序总用时: " + (end - start) + " 毫秒");
    }
    private static void processFile(File file, Map<String, Integer> wordMap) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String tmpStr;
            while ((tmpStr = br.readLine()) != null) {
                String[] split = tmpStr.trim().split("\\s+");
                for (int i = 0; i < split.length; i++) {
                    String word = split[i];
                    wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
