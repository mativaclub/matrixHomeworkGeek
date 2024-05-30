import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {
        int field = 265; //4 byte
        byte firstByte = (byte) field; // 1 right byte = 0000 1001 -> 9
        System.out.println(firstByte);
        byte secondByte = (byte) (field >> 8); // отбрасываем правую часть и получаем 2ой байт, что был слева и стал правым
        byte thirdByte = (byte) (field >> 16);
        try(FileOutputStream fileOutputStream = new FileOutputStream("bytes.dat")){
            fileOutputStream.write(thirdByte);
            fileOutputStream.write(secondByte);
            fileOutputStream.write(firstByte);
        }
        catch (IOException e){
            System.out.println("Error");
        }
    }
}
