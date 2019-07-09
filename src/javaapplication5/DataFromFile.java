/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication5;

import com.opencsv.CSVReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 *
 * @author nazarov
 */
public class DataFromFile {

   private static String SAMPLE_CSV_FILE_PATH = "";
   List<String[]> allRows; // главный лист всех даных обрабатываемых и отображаемых
   String[] listNamedGraph = null; // Список таблиц
   int columnTime = 0;
   boolean delStrName = true;
   
   DataFromFile(String path) {
     SAMPLE_CSV_FILE_PATH = path;
     }
   // Чтение файла с данными
   void generationData() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        InputStreamReader reader1 = new InputStreamReader(new FileInputStream(SAMPLE_CSV_FILE_PATH), "UTF8");  // тут отличия от оригинала так как нужно декодировать
        CSVReader reader = new CSVReader(reader1, '\t', '"');
        this.allRows = reader.readAll();
        
        int strN =0; // Переменная для определнеие строки имени
        for(String[] row : allRows){ 
            if (row.length <=1){ // проверяем есть ли хоть два столбца
              ++strN;
              continue;}
            else {
              boolean acces = false;
              for(int i=0; i<row.length; ++i) // пробегаем по строке 
              {
                  if (checkString(row[i])) acces = false; // Определяем числа ли это если хоть один цыфры то пропуск
                  else acces = true;
              }
              if (acces){
              listNamedGraph = new String[row.length]; // создаем массив такой же длинны как row
              System.arraycopy( row,0 ,listNamedGraph, 0, row.length); // Копируем полностью массив имени
              break;
              }
              } 
        }
       // System.out.println("Before size ->" + allRows.size());
        // Удаляем ненужные данные вместе с именами список выше их есть
        for(int id=0; id<strN; ++id){
          //  System.out.println("What is del --> " + allRows.get(id)[0]);
            allRows.remove(0); // С какого элемента удаляем ненужное
          //  System.out.println("len allRows --> " + allRows.size());
        } 
       // System.out.println("After size ->" + allRows.size());
       // System.out.println("String num data --> " + strN);
        
        if (delStrName) allRows.remove(0); // если хотим удалить строку с именами колонок
       }
    
    //Фукция проверки строка ли это
    public boolean checkString(String string) {
        try {
            Double.parseDouble(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    //Возвращает список с названиями столбцов
    String[] getlistNamedGraph(){
    return listNamedGraph;
    }
    
    //Возвращает пустые или уже урезанные данные
    List<String[]> getAllRows(){
    return allRows;
    }
    
      public static void main(String args[]) throws UnsupportedEncodingException, IOException {
       DataFromFile datafromfile = new DataFromFile("C:\\Users\\Nazarov\\Documents\\NetBeansProjects\\JavaApplication5\\134_m-k_k-m - копия.txt");
       datafromfile.generationData();
       String[] massName = datafromfile.getlistNamedGraph();
       
       for(int i=0; i<massName.length; ++i){System.out.println(massName[i]);
       
       }
      
      List<String[]> local_allRows = datafromfile.getAllRows(); // Получаем преобразованное
          System.out.println("After size Preobrazovannoe in main ->" + datafromfile.getAllRows().size());
      // пробежимся по данным
      for(String[] row : local_allRows){ // где то пролет с удалением
        for(int i=0; i<row.length; ++i){System.out.print(row[i] + " ");
        }
        System.out.println();
      }
      }
      
}
      
