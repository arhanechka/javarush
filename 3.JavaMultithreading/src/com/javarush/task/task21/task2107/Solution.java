package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Solution clone() throws CloneNotSupportedException {
        Map<String, User> users = new LinkedHashMap();
        for(Map.Entry<String,User> us : this.users.entrySet()){

            users.put(us.getKey(), us.getValue().clone());
        }
        Solution solution = new Solution();
        solution.users.putAll(users);
        return solution;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected User clone() throws CloneNotSupportedException {
            return new User (this.age, this.name);
        }
        public boolean equals(Object o){
            if (this==o) return true;
            if (o==null || this.getClass()!=o.getClass())
                return false;
            if (!(o instanceof User))
                return false;
            if (age != ((User) o).age) return false;
            if (name != null ? !name.equals(((User) o).name) : ((User) o).name != null) return false;
            return true;
    }

    public int hashCode(){
        int result=age;
        result=31*result+(name != null ? name.hashCode() : 0);

    return result;}
    }}
