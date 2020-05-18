import java.util.Scanner;

public class Menu {
    PhoneBookManager phoneBookManager = new PhoneBookManager();
    Scanner scanner = new Scanner(System.in);
    Scanner input = new Scanner(System.in).useDelimiter("\n");
    public void edit(){
        System.out.print("nhập vào số điện thoại của danh bạ cần sửa: ");
        String editPhoneNumber = scanner.next();
        if (editPhoneNumber==null){
            start();
        }else{
            if (phoneBookManager.checkPhoneNumber(editPhoneNumber)){
                System.out.print("Name: ");
                String editName = input.next();
                System.out.print("address: ");
                String editAddress = input.next();
                System.out.print("group: ");
                String editGroup = input.next();
                System.out.print("gender: ");
                String editGender = input.next();
                System.out.print("dateOfBirth: ");
                String editDateOfBirth = input.next();
                phoneBookManager.edit(editName,editPhoneNumber,editAddress,editGroup,editGender,editDateOfBirth);
            }else{
                System.out.println("không tìm được danh bạ với số điện thoại trên");
                edit();
            }
        }
    }
    public void delete(){
        System.out.print("nhập vào số điện thoại của danh bạ cần xóa: ");
        String deletePhoneNumber = scanner.next();
        if (deletePhoneNumber==null){
            start();
        }else{
            if (phoneBookManager.checkPhoneNumber(deletePhoneNumber)){
                System.out.print("bạn có muốn xóa: ");
                String check = input.next();
                if (check.equals("y")){
                    phoneBookManager.delete(deletePhoneNumber);
                }else{
                    start();
                }
            }else{
                System.out.println("không tìm được danh bạ với số điện thoại trên");
                delete();
            }
        }
    }
    public void find(){
        System.out.println("Sort option:");
        System.out.println("1. họ tên");
        System.out.println("2. số diện thoại");
        System.out.print("Your choose: ");
        int sortOption = scanner.nextInt();
        switch (sortOption) {
            case 1:
                System.out.println("nhập vào tên:");
                String name = scanner.next();
                phoneBookManager.findName(name);
                break;
            case 2:
                System.out.println("nhập vào số điện thoại:");
                String phoneNumber = scanner.next();
                phoneBookManager.findPhoneNumber(phoneNumber);
                break;
        }
    }
    public void start(){
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("chọn chức năng theo số (để tiếp tục)");
        System.out.println("1.xem danh sách");
        System.out.println("2.thêm mới");
        System.out.println("3.cập nhật");
        System.out.println("4.xóa");
        System.out.println("5.tìm kiếm");
        System.out.println("6.đọc từ file");
        System.out.println("7.ghi từ file");
        System.out.println("8.thoát");
        String choose = scanner.next();
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        switch (choose) {
            case "1":
                phoneBookManager.read();
                phoneBookManager.show();
                break;
            case "2":
                System.out.print("Name: ");
                String name = input.next();
                System.out.print("phoneNumber: ");
                String phoneNumber = input.next();
                System.out.print("address: ");
                String address = input.next();
                System.out.print("group: ");
                String group = input.next();
                System.out.print("gender: ");
                String gender = input.next();
                System.out.print("dateOfBirth: ");
                String dateOfBirth = input.next();
                phoneBookManager.add(name, phoneNumber, address, group,gender,dateOfBirth);
                phoneBookManager.save();
                break;
            case "3":
                edit();
                phoneBookManager.save();
                break;
            case "4":
                delete();
                phoneBookManager.save();
                break;
            case "5":
                find();
                break;
            case "6":
                phoneBookManager.read();
                break;
            case "7":
                phoneBookManager.save();
                break;
            case "8":
                System.exit(0);
            default:
                System.out.println("Wrong option, please choose again !");
        }
        start();
    }
}
