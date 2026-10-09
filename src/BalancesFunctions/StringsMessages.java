package BalancesFunctions;

public class StringsMessages<T> {

    public void ShowUISetup() {

        int SIZE = ((20 * 2) * 2) / 2;
        ClientsUI UI = new ClientsUI();

        String line = "-";

        UI.SetUISize(SIZE);
        double d = line.length() * UI.Get();
        System.out.print(line.repeat((int)d) + "\n");

    }

}
