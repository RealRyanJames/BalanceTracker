package BalancesFunctions;

interface UIParent {
    void SetUISize(int sizeUI);
}

public class ClientsUI implements UIParent {

    private static int SizeElement;

    @Override
    public void SetUISize(int sizeUI) {
        SizeElement = sizeUI;
    }

    public int Get() {
        return SizeElement;
    }
}
