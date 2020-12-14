import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function implements DisPlayPhone, Serializable {
        Scanner sc = new Scanner(System.in);
private ArrayList<Constact> constacts = new ArrayList<>();
public ArrayList<Constact> getConstacts(){ return constacts;};
public void setConstacts(ArrayList<Constact>constacts){
    this.constacts = constacts;}

    @Override
    public void addInfos() throws IOException, ClassNotFoundException {
        int input = 0;
        do {
            System.out.println("chọn chức năng ");
            System.out.println("1 : nhập  thông tin");
            System.out.println("2 : thoát");
            try {
                input = Integer.parseInt(sc.nextLine());
                switch (input) {
                    case 1:
                        Constact constacts = new Constact();
                        boolean check = false;
                        do {
                            System.out.println("nhập sdt");
                            String s = "^(09|01[2|6|8|9])+([0-9]{8})\\b";
                            String line = sc.nextLine();
                            Pattern pattern = Pattern.compile(s);
                            Matcher matcher = pattern.matcher(line);
                            if (matcher.find()) {
                                constacts.setNumberPhone(line);
                                check = true;
                            } else {
                                System.out.println("Vui Lòng Không Để Trống");
                            }
                        } while (!check);

                        System.out.println("nhập nhóm ");
                        String group = sc.nextLine();
                        constacts.setGroupName(group);
                        System.out.println("nhập tên");
                        String name = sc.nextLine();
                        constacts.setName(name);
                        System.out.println("Nhập giới tính ");
                        String male = sc.nextLine();
                        constacts.setMaleOrFemale(male);
                        boolean check0 = false;
                        do {
                            System.out.println("Nhập ngày sinh: dd/MM/yyyy");
                            String dateOfBirth = sc.nextLine();
                            String line = sc.nextLine();
                            String regex = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
                                    "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
                                    "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
                                    "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
                            Pattern pattern = Pattern.compile(regex);
                            Matcher matcher = pattern.matcher(line);
                            if (matcher.find()) {
                                check0 = true;
                                constacts.setDateOfBirth(line);
                            } else {
                                System.out.println("Vui lòng nhập lại:");
                            }
                        } while (!check0);
                        getConstacts().add(constacts);

                        boolean check1 = false;
                        do {
                            System.out.println("nhập địa chỉ email ");
                            String s = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
                            String line = sc.nextLine();
                            Pattern pattern = Pattern.compile(s);
                            Matcher matcher = pattern.matcher(line);
                            if (matcher.find()) {
                                check1 = true;
                                constacts.seteMail(line);
                            } else {
                                System.out.println("Vui Lòng Không Để Trống");
                            }
                        } while (!check1);
                        getConstacts().add(constacts);
                        break;
                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("mời nhập lại ");
            }
        } while (input != 2);
    }

    @Override
    public void show() throws IOException, ClassNotFoundException {

        int n = 0;
        do {
            System.out.println(" --> chọn chức năng <-- ");
            System.out.println("1: hiển thị");
            System.out.println("2: thoát" );
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    for (Constact constacts : getConstacts()) {
                        System.out.println(constacts.toString());
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("mời nhập lại");
            }
        } while (n != 2);
    }

    @Override
    public void search() {
        int n = 0;
        do {
            System.out.println("Chọn Chức Năng");
            System.out.println("1 : Tìm");
            System.out.println("2 : Thoát ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập Thông Tin Cần Tìm :");
                    String regex = sc.nextLine();
                    int index = 0;
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher;
                    for (int i = 0; i < getConstacts().size(); i++) {
                        matcher = pattern.matcher(getConstacts().get(i).getName());
                        if (matcher.find()) {
                            System.out.println("STT " + i + " : " + getConstacts().get(i).toString());
                            index++;
                        }
                    }
                    if (index <= 0) {
                        System.out.println("Tên này không có trong danh sách\n ");
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhâp vào đê ");
            }
        } while (n != 2);
    }

    @Override
    public void edit() {
        int num = 0;
        do {
            System.out.println("Nhập Thông tin cần sửa ");
            System.out.println("Chọn Chỉnh Sửa Theo ");
            System.out.println("1 : theo tên");
            System.out.println("2 : theo số điện thoại ");
            try {
                num = Integer.parseInt(sc.nextLine());
                String edit;
                int n = 0;
                switch (num) {
                    case 1:
                        System.out.println("Tên Cần Chỉnh :");
                        edit = sc.nextLine();
                        for (Constact name : getConstacts()) {
                            if (edit.equals(name.getName())) {
                                System.out.println("Chỉnh tên : ");
                                String add = sc.nextLine();
                                name.setName(add);
                                System.out.println("Tên sau khi chỉnh sửa " + name.getName());
                                n++;
                                break;
                            }
                        }
                        if (n == 0) {
                            System.out.println("tên không co trong danh sách");
                            break;
                        }
                    case 2:
                        System.out.println("nhập tên cần chỉnh lại số ");
                        edit = sc.nextLine();
                        for (Constact numberPhone : getConstacts()) {
                            if (edit.equals(numberPhone.getName())) {
                                System.out.println("chỉnh lại ");
                                String add = sc.nextLine();
                                numberPhone.setNumberPhone(add);
                                n++;
                                break;
                            }
                        }
                        if (n == 0) {
                            System.out.println("tên ko có trong danh bạ");
                            break;
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("nhập lại");
            }
        } while (num != 3);
    }

    @Override
    public void delete() {
        int n = 0;
        do {
            System.out.println("1: Xóa");
            System.out.println("2: Thoát");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập tên cần xóa ");
                    String id = sc.nextLine();
                    Constact constact = null;
                    int size = getConstacts().size();
                    for (int i = 0; i < size; i++) {
                        if (constacts.get(i).getName().equals(id)) {
                            constact = getConstacts().get(i);
                            break;
                        }
                    }
                    if (constact != null) {
                        System.out.println("Đã Xóa Tên Là : \n" + constact.getName());
                        getConstacts().remove(constact);
                    } else {
                        System.out.println("Không Có tên Trong Danh Sách");
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhập sai rồi");
            }
        } while (n != 2);
    }
}
