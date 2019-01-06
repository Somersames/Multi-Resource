import org.junit.Test;

/**
 * @author szh
 * @create 2019-01-06 15:15
 **/
public class NumberTest {
    @Test
    public void numTest(){
        for( int a =0; a<10;a++){
            for(int b =0;b<10;b++){
                for( int c =0;c<10;c++){
                    for(int d = 0;d<10;d++){
                        int sum = a*1000 + b*100 + c*10+ d;
                        int total = d*1000+c*100+b*10+a;
                        if( (sum * 9) == total){
                            System.out.println(a);
                            System.out.println(b);
                            System.out.println(c);
                            System.out.println(d);
                        }
//                        System.out.println(sum);
//                        System.out.println((sum * 9));
//                        System.out.println(total);
                    }
                }
            }
        }
    }

    @Test
    public void t2Test(){
        for(int a  =0 ;a <10 ;a++){
            for(int b = 0 ;b<10;b++){
                for(int c =0 ;c<10;c++){

                }
            }
        }
    }
}
