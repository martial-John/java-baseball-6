package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int cont = 0;
        while (cont < 2) {
            System.out.println("숫자 야구 게임을 시작합니다");
            game.beforeRun();
            cont = 0;
            while (cont == 0) {
                cont = game.run();
            }
        }

    }
}
