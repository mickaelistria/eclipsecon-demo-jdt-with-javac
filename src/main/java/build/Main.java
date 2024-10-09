package build;

public class Main {
    public static void main(String[] args) {
        Dto dto = DtoFactory.createDto();
        System.out.println(dto);
        dto.name();
    }
}
