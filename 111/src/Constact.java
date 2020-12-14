import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Constact {
    private String name;
    private String numberPhone;
    private String eMail;
    private String maleOrFemale;
    private String dateOfBirth;
    private String GroupName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMaleOrFemale() {
        return maleOrFemale;
    }

    public void setMaleOrFemale(String maleOrFemale) {
        this.maleOrFemale = maleOrFemale;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    @Override
    public String toString() {
        return "Constacts{" +
                "name='" + name + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", eMail='" + eMail + '\'' +
                ", maleOrFemale='" + maleOrFemale + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", GroupName='" + GroupName + '\'' +
                '}';
    }
    public void add(){
        Scanner sc = new Scanner(System.in);

        boolean check = false;
        do {
            System.out.println("nhập số điện thoại");
            String s = "^(09|01[2|6|8|9])+([0-9]{8})\\b";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check = true;
                numberPhone = line;
            } else {
                System.out.println("mời nhập lại");
            }
        }while (!check);

        boolean check1 = false;
        do {
            System.out.println("nhập Email: ");
            String s = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check1 = true;
                eMail = line;
            } else {
                System.out.println(" mời nhập lại: ");
            }
        }while (!check1);
        System.out.println("mời nhập tên");
        name = sc.nextLine();

        System.out.println("giới tính:");
        maleOrFemale = sc.nextLine();

        System.out.println("ngày sinh");
        dateOfBirth = sc.nextLine();

        System.out.println(" nhập vào tên nhóm:");
    }

}
