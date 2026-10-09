import BalancesFunctions.StringsMessages;

enum TypeExitCode {
    Error,
    ExitErrorCode,
    ExitCodePaste
}

static class ExitCode {

    public int GetType(TypeExitCode code) {
        if (code == TypeExitCode.ExitErrorCode) {
            return 1;
        } else if (code == TypeExitCode.Error) {
            return 1;
        } else if (code == TypeExitCode.ExitCodePaste) {
            return 0;
        }

        return 0;
    }
}

void main() {

    String input = "Title: Balance Tracker CLI";
    Scanner s = new Scanner(input);
    StringBuilder strBuilder = new StringBuilder();
    while(s.hasNextLine()) {

        String l = s.nextLine();
        strBuilder.append(l);
    }

    String r = strBuilder.toString();
    System.out.print(r + "\n");

    s.close();
    Scanner scan = new Scanner(System.in);
    ExitCode codeError = new ExitCode();

    String messages = "Welcome to My Balance Program v1";
    System.out.print(messages + "\n");

    StringsMessages message = new StringsMessages();
    message.ShowUISetup();

    double itemCount = 0.0;
    System.out.print("=> Enter Item Length: " + (itemCount + 1) + "\n");
    message.ShowUISetup();
    itemCount += scan.nextDouble();


    for (int count = 0; count < itemCount; count++) {

        double itemStack = 0.0;
        System.out.print("=> Enter Item Price: " + (itemCount + 1) + "\n");
        itemStack += scan.nextDouble();

        double calc = itemStack + count;
        System.out.print("=> You Will Have Already Spent: $" + calc);

        if ((int) itemCount != 0) {

            System.exit(codeError.GetType(TypeExitCode.Error));
        }

        File file = new File("Calc.txt");

        try (FileWriter write = new FileWriter(file.getName())) {
            write.write("=> You Will Have Already Spent: $" + calc);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    System.exit(codeError.GetType(TypeExitCode.ExitCodePaste));
}