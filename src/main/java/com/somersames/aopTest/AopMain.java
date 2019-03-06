package com.somersames.aopTest;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @author szh
 * @create 2019-03-05 22:27
 **/
@Service
@Data
public class AopMain {
    private String field1 = "a";
    private String field2 = "b";



    public void say(){
        System.out.println(this.field1);
    }
}
