import BalancesFunctions.StringsMessages;

enum TypeExitCode {
    Error,
    ExitErrorCode,
    ExitCodePaste
}

static String createdBy() {

    return "ZumbaCodes | Ryan".toUpperCase();
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

static class NameUser implements User {

    @Override
    public String GetUserName() {
        return "Created By: " + createdBy();
    }

    @Override
    public long lengthName() {
        return GetUserName().length();
    }
}

void main() {
    ExitCode codeError = new ExitCode();

    NameUser user = new NameUser();

    String input = "Title: Balance Tracker CLI";
    String nameOfUser = user.GetUserName();
    if (user.lengthName() > 1) {

        Scanner s = new Scanner(input);
        StringBuilder strBuilder = new StringBuilder();
        while (s.hasNextLine()) {

            String l = s.nextLine();
            strBuilder.append(l);
        }

        String r = strBuilder.toString();
        System.out.print(r + "\n");

        s.close();
        Scanner scan = new Scanner(System.in);

        String messages = "Welcome to My Balance Program v1";
        System.out.print(messages + "\n");
        System.out.print(nameOfUser + "\n");

        StringsMessages<Void> message = new StringsMessages<>();
        message.ShowUISetup();

        System.out.print("=> Add['Y', 'A']\n");
        System.out.print("=> Sub['N', 'S']\n");
        String inputByUser = scan.nextLine();
        if (inputByUser.equals("Y") || inputByUser.equals("A")) {

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
        }
        else if (inputByUser.equals("N") || inputByUser.equals("S") ) {

            double itemCount = 0.0;
            System.out.print("=> Enter Item Length: " + (itemCount + 1) + "\n");
            message.ShowUISetup();
            itemCount += scan.nextDouble();

            for (int count = 0; count < itemCount; count++) {

                double itemStack = 0.0;
                System.out.print("=> Enter Item Price: " + (itemCount + 1) + "\n");
                itemStack += scan.nextDouble();

                double calc = itemStack - count;
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
        }

    }

    System.exit(codeError.GetType(TypeExitCode.ExitCodePaste));
}