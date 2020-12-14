import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Function function = new Function();
        int cases = 0;
        do {
            System.out.println("chương trình quản lý danh bạ ");
            System.out.println("chọn chức năng");
            System.out.println("1 : thêm mới danh bạ");
            System.out.println("2 : xem danh bạ");
            System.out.println("3 : xóa");
            System.out.println("4 : tìm kiếm ");
            System.out.println("5 : sửa thông tin");
            System.out.println("6 : exit ");
            try {
                cases = Integer.parseInt(sc.nextLine());
                switch (cases) {
                    case 1:
                        function.addInfos();
                        break;
                    case 2:
                        function.show();
                        break;
                    case 3:
                        function.delete();
                        break;
                    case 4:
                        function.search();
                        break;
                    case 5:
                        function.edit();
                        break;
                }
            } catch (Exception e) {
                System.out.println("nhập lại đê ");
            }
        } while (cases != 6);
    }

}
