package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution2 {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("new2.txt");
            File loadFile = new File("new1.txt");
            OutputStream outputStream = new FileOutputStream(loadFile);
            InputStream inputStream = new FileInputStream(your_file_name);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setFirstName("John");
            user1.setLastName("Smith");
            user1.setBirthDate(sdf.parse("10.09.1976"));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user1);
            User user2 = new User();

            user2.setLastName("Santon");
            // user2.setBirthDate(sdf.parse("21.12.1973"));
            //user2.setMale(false);
            //user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user2);


            User user3 = new User();
            user3.setFirstName("George");

            user3.setBirthDate(sdf.parse("20.01.1972"));
            user3.setMale(true);
            user3.setCountry(User.Country.OTHER);
            javaRush.users.add(user3);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String firstName;
            String lastName;
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);


            if (this.users != null)
                for (User user : users) {
                    //  printWriter.println("newnewnew");
                    if (user.getFirstName() == null) {
                        firstName = "null";
                    } else
                        firstName = user.getFirstName();
                    printWriter.println(firstName);
                    if (user.getLastName() == null) {
                        lastName = "null";
                    } else
                        lastName = user.getLastName();
                    printWriter.println(lastName);
                    if (user.getBirthDate() == null) {
                        printWriter.println("null");
                    } else
                        printWriter.println(df.format(user.getBirthDate()));

                    printWriter.println(String.valueOf(user.isMale()));
                    if (user.getCountry() == null) {
                        printWriter.println("null");
                    } else

                        printWriter.println(String.valueOf(user.getCountry().getDisplayedName()));
                }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            int i = 0;
            while ((str = br.readLine()) != null) {
                {
                    User user = new User();

                    user.setFirstName(isNull(str));
                    user.setLastName(isNull(br.readLine()));

                    String date = br.readLine();
                    if (isNull(date) == null) {
                        user.setBirthDate(null);
                    } else {
                        Date date1 = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(date);
                        user.setBirthDate(date1);
                    }
                    String sex = br.readLine();
                    if (sex.equals("true")) {
                        user.setMale(true);
                    } else {
                        user.setMale(false);
                    }
                    String country = br.readLine();
                    switch (country) {
                        case ("Russia"): {
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        }
                        case ("Ukraine"): {
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        }
                        case ("null")
                                : {
                            user.setCountry(null);
                            break;
                        }
                        default: {
                            user.setCountry(User.Country.OTHER);
                            break;
                        }
                    }
                    users.add(user);
                }
            }
            br.close();
        }

        public String isNull(String str) {
            String temp;
            if (str.equals("null")) {
                temp = null;
            } else {
                temp = str;
            }
            return temp;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }

}