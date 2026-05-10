package com.xyq.dao;
//把entity包下的Person类导入到当前文件
import com.xyq.entity.Person;
//package表示声明，import表示导入
//必须先写package，再写import或者说package必须写在有效代码的第一行
public class TestPerson {
    public static void main(String[] args) {
        Person P = new Person();
    }
}
