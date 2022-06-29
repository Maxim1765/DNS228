import java.io.*;
import java.util.Scanner;

public class MainSHOP {
    static String inputString(String message) {
        boolean isValidInput;
        String output = "";
        do {
            try {
                isValidInput = true;
                Scanner scanner = new Scanner(System.in);

                System.out.print(message);
                output = scanner.nextLine();
            } catch (Exception e) {
                isValidInput = false;
                System.out.println("Ошибка ввода. Пожалуйста повторите ввод");
            }

        } while (isValidInput == false);

        return output;
    }
    static int inputInt(String message, int min, int max) {
        boolean isValidInput;
        int output = 0;
        do {
            try {
                isValidInput = true;
                Scanner scanner = new Scanner(System.in);

                System.out.print(message);
                output = scanner.nextInt();

                if (output < min || output > max) {
                    System.out.println("Ошибка ввода. Вы вышли за границы диапазона от " + min + " до " + max);
                    throw new Exception();
                }

            } catch (Exception e) {
                isValidInput = false;
                System.out.println("Ошибка ввода. Пожалуйста повторите ввод");
            }

        } while (isValidInput == false);

        return output;
    }

    //region class, enum
    enum SortDirection {
        ASC,
        DESC
    }

    static int lastPhoneId = 0;

    static class Phone {
        public int id;
        public String model;
        public int price;
        public int amount;

        public Phone(int id, String model, int price, int amount) {
            this.id = id;
            this.model = model;
            this.price = price;
            this.amount = amount;
        }
    }

    static int lastIdAppliances = 0;
    static class appliances{
        public int idAPP;
        public String modelAPP;
        public int priceAPP;
        public int amountAPP;
        public appliances(int idAPP, String modelAPP, int priceAPP, int amountAPP) {
            this.idAPP = idAPP;
            this.modelAPP = modelAPP;
            this.priceAPP = priceAPP;
            this.amountAPP = amountAPP;
        }
    }
    static int lastACCId = 0;
    static class accessories{
        public int idACC;
        public String modelACC;
        public int priceACC;
        public int amountACC;

        public accessories(int idACC, String modelACC, int priceACC, int amountACC) {
            this.idACC = idACC;
            this.modelACC = modelACC;
            this.priceACC = priceACC;
            this.amountACC = amountACC;
        }
    }
//endregion

    //region get by id
    static Phone getPhoneById(Phone[] phones, int id) {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].id == id) {
                return phones[i];
            }
        }
        return null;
    }

    static accessories getACCbyID(accessories[] accessoriess, int idACC){
        for (int i = 0; i < accessoriess.length; i++) {
            if (accessoriess[i].idACC == idACC){
                return accessoriess[i];
            }
        }
        return null;
    }

    static appliances getAPPdyId(appliances[] appliancesa, int id1){
        for (int i = 0; i < appliancesa.length; i++) {
            if(appliancesa[i].idAPP == id1){
                return appliancesa[i];
            }
        }
        return null;
    }
    //endregion

    //region get index by id
    static int getIndexPhoneById(Phone[] phones, int id) {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].id == id) {
                return i;
            }
        }
        return -1;
    }

    static int getIndexACCById(accessories[] accessoriess, int idACC) {
        for (int i = 0; i < accessoriess.length; i++) {
            if (accessoriess[i].idACC == idACC) {
                return i;
            }
        }
        return -1;
    }

    static int getIndexAppliancesById(appliances[] appliancesa, int id1){
        for (int i = 0; i < appliancesa.length; i++) {
            if(appliancesa[i].idAPP == id1){
                return i;
            }
        }
        return -1;
    }

//endregion

    //region create
    static Phone createPhone() {
        String model = inputString("Введите модель товара: ");

        int price = inputInt("Введите цену товара: ", 1, 1000000);

        int amount = inputInt("Введите количество товаров на складе: ", 1, 10000);

        return new Phone(0, model, price, amount);
    }

    static accessories createACC() {
        String modelACC = inputString("Введите модель товара: ");

        int priceACC = inputInt("Введите цену товара: ", 1, 1000000);

        int amountACC = inputInt("Введите количество товаров на складе: ", 1, 10000);

        return new accessories(0, modelACC, priceACC, amountACC);
    }

    static appliances createAppliances(){
        String modelAPP = inputString("Введите модель товара:");

        int priceAPP = inputInt("Введите цену товара:", 1, 100000);

        int amountAPP = inputInt("Введите количество товара на складе:", 1, 10000);

        return new appliances(0, modelAPP, priceAPP, amountAPP);
    }
    //endregion

    //region create empty array
    static Phone[] createEmptyPhonesArray() {
        return new Phone[0];
    }

    static appliances[] createEmptyAppliancesArray(){
        return new appliances[0];

    }

    static accessories[] createEmptyACCArray() {
        return new accessories[0];
    }
    //endregion

    //region add phone to end of array
    static Phone[] addPhoneToEndOfArray(Phone[] phones, Phone insertedPhone) {


        Phone[] tempPhones = new Phone[phones.length + 1];

        for (int i = 0; i < phones.length; i++) {
            tempPhones[i] = phones[i];
        }

        tempPhones[tempPhones.length - 1] = insertedPhone;


        return tempPhones;
    }

    static appliances[] addAPPtoEndOfArray(appliances[] appliancesa, appliances insertAPP){

        appliances[] tempAPP = new appliances[appliancesa.length + 1];

        for (int i = 0; i <appliancesa.length ; i++) {
            tempAPP[i] = appliancesa[i];
        }

        tempAPP[tempAPP.length - 1] = insertAPP;

        return tempAPP;
    }

    static accessories[] addACCToEndOfArray(accessories[] accessoriess, accessories insertedACC) {


        accessories[] tempACC = new accessories[accessoriess.length + 1];

        for (int i = 0; i < accessoriess.length; i++) {
            tempACC[i] = accessoriess[i];
        }

        tempACC[tempACC.length - 1] = insertedACC;


        return tempACC;
    }
    //endregion

    //region update by id
    static void updatePhoneById(Phone[] phones, int updatedIdPhone) {
        Phone foundPhone = getPhoneById(phones, updatedIdPhone);

        if (foundPhone == null) {
            System.out.println("Ошибка. Телефон с таким ID не найден.");
            return;
        }

        System.out.println("Введите данные телефона для обновления");
        Phone updatedPhone = createPhone();

        foundPhone.model = updatedPhone.model;
        foundPhone.price = updatedPhone.price;
        foundPhone.amount = updatedPhone.amount;

        System.out.println("Телефон обновлён успешно!");
    }

    static void updateAPPById(appliances[] appliancesa, int updatedIdAPP) {
        appliances foundPhone = getAPPdyId(appliancesa, updatedIdAPP);

        if (foundPhone == null) {
            System.out.println("Ошибка. Товар с таким ID не найден.");
            return;
        }

        System.out.println("Введите данные товара для обновления");
        appliances updatedPhone = createAppliances();

        foundPhone.modelAPP = updatedPhone.modelAPP;
        foundPhone.priceAPP = updatedPhone.priceAPP;
        foundPhone.amountAPP = updatedPhone.amountAPP;

        System.out.println("Товар обновлён успешно!");
    }

    static void updateACCById(accessories[] accessoriess, int updatedIdACC) {
        accessories foundACC = getACCbyID(accessoriess, updatedIdACC);

        if (foundACC == null) {
            System.out.println("Ошибка. Телефон с таким ID не найден.");
            return;
        }

        System.out.println("Введите данные телефона для обновления");
        accessories updatedACC = createACC();

        foundACC.modelACC = updatedACC.modelACC;
        foundACC.priceACC = updatedACC.priceACC;
        foundACC.amountACC = updatedACC.amountACC;

        System.out.println("Товар обновлён успешно!");
    }
    //endregion

    //region delete by id
    static Phone[] deletePhoneById(Phone[] phones, int deletedIdPhone) {
        int foundPhoneIndex = getIndexPhoneById(phones, deletedIdPhone);

        if (foundPhoneIndex == -1) {
            System.out.println("Ошибка. Телефон с таким ID не найден. Удаление не возможно");
            return phones;
        }

        Phone[] tempPhones = new Phone[phones.length - 1];
        int tempPhonesIndex = 0;

        for (int i = 0; i < phones.length; i++) {
            if (i != foundPhoneIndex) {
                tempPhones[tempPhonesIndex] = phones[i];
                tempPhonesIndex++;
            }
        }

        System.out.println("Телефон удалён успешно!");

        return tempPhones;
    }

    static appliances[] deleteAPPById(appliances[] appliancesa, int deletedIdAPP) {
        int foundPhoneIndex = getIndexAppliancesById(appliancesa, deletedIdAPP);

        if (foundPhoneIndex == -1) {
            System.out.println("Ошибка. Телефон с таким ID не найден. Удаление не возможно");
            return appliancesa;
        }

        appliances[] tempAPPs = new appliances[ appliancesa.length - 1];
        int tempPhonesIndex = 0;

        for (int i = 0; i < appliancesa.length; i++) {
            if (i != foundPhoneIndex) {
                tempAPPs[tempPhonesIndex] = appliancesa[i];
                tempPhonesIndex++;
            }
        }

        System.out.println("Товар удалён успешно!");

        return tempAPPs;
    }

    static accessories[] deleteACCById(accessories[] accessoriess, int deletedIdACC) {
        int foundPhoneIndex = getIndexACCById(accessoriess, deletedIdACC);

        if (foundPhoneIndex == -1) {
            System.out.println("Ошибка. Товар с таким ID не найден. Удаление не возможно");
            return accessoriess;
        }

        accessories[] tempACC = new accessories[accessoriess.length - 1];
        int tempACCIndex = 0;

        for (int i = 0; i < accessoriess.length; i++) {
            if (i != foundPhoneIndex) {
                tempACC[tempACCIndex] = accessoriess[i];
                tempACCIndex++;
            }
        }

        System.out.println("Товар удалён успешно!");

        return tempACC;
    }
    //endregion

    //region sell
    static Phone[] sellPhone(Phone[] phones, int soldIdPhone) {
        Phone foundPhone = getPhoneById(phones, soldIdPhone);

        if (foundPhone == null) {
            System.out.println("Ошибка. Телефон с таким ID не найден. Продажа не возможна");
            return phones;
        }

        int soldAmount = inputInt("Введите кол-во телефонов для покупки: ", 1, foundPhone.amount);

        foundPhone.amount -= soldAmount;

        if (foundPhone.amount == 0) {
            phones = deletePhoneById(phones, foundPhone.id);
        }

        System.out.println("Покупка осуществлена успешно!");

        return phones;
    }

    static appliances[] sellAPP(appliances[] appliancesa, int soldIdAPP) {
        appliances foundPhone = getAPPdyId(appliancesa, soldIdAPP);

        if (foundPhone == null) {
            System.out.println("Ошибка. Телефон с таким ID не найден. Продажа не возможна");
            return appliancesa;
        }

        int soldAmount = inputInt("Введите кол-во телефонов для покупки: ", 1, foundPhone.amountAPP);

        foundPhone.amountAPP -= soldAmount;

        if (foundPhone.amountAPP == 0) {
            appliancesa = deleteAPPById(appliancesa, foundPhone.idAPP);
        }

        System.out.println("Покупка осуществлена успешно!");

        return appliancesa;
    }

    static accessories[] sellACC(accessories[] accessoriess, int soldIdACC) {
        accessories foundACC = getACCbyID(accessoriess, soldIdACC);

        if (foundACC == null) {
            System.out.println("Ошибка. Телефон с таким ID не найден. Продажа не возможна");
            return accessoriess;
        }

        int soldAmount = inputInt("Введите кол-во телефонов для покупки: ", 1, foundACC.amountACC);

        foundACC.amountACC -= soldAmount;

        if (foundACC.amountACC == 0) {
            accessoriess = deleteACCById(accessoriess, foundACC.idACC);
        }

        System.out.println("Покупка осуществлена успешно!");

        return accessoriess;
    }
    //endregion

    //region find by price
    static Phone[] findPhonesByPrice(Phone[] phones, int minPrice, int maxPrice) {
        Phone[] foundPhones = createEmptyPhonesArray();

        for (int i = 0; i < phones.length; i++) {
            if (phones[i].price >= minPrice && phones[i].price <= maxPrice) {
                foundPhones = addPhoneToEndOfArray(foundPhones, phones[i]);
            }
        }

        return foundPhones;
    }

    static appliances[] findAPPByPrice(appliances[] appliancesa, int minPrice, int maxPrice) {
        appliances[] foundAPP = createEmptyAppliancesArray();

        for (int i = 0; i < appliancesa.length; i++) {
            if (appliancesa[i].priceAPP >= minPrice && appliancesa[i].priceAPP <= maxPrice) {
                foundAPP = addAPPtoEndOfArray(foundAPP, appliancesa[i]);
            }
        }

        return foundAPP;
    }

    static accessories[] findACCByPrice(accessories[] accessoriess, int minPrice, int maxPrice) {
        accessories[] foundACC = createEmptyACCArray();

        for (int i = 0; i < accessoriess.length; i++) {
            if (accessoriess[i].priceACC >= minPrice && accessoriess[i].priceACC <= maxPrice) {
                foundACC = addACCToEndOfArray(foundACC, accessoriess[i]);
            }
        }

        return foundACC;
    }
    //endregion

    //region sort by amount
    static void sortPhonesByAmount(Phone[] phones, SortDirection sortDirection) {
        for (int i = 0; i < phones.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < phones.length; j++) {

                if (sortDirection == SortDirection.ASC) {
                    if (phones[j].amount < phones[index].amount) {
                        index = j;
                    }
                } else if (sortDirection == SortDirection.DESC) {
                    if (phones[j].amount > phones[index].amount) {
                        index = j;
                    }
                }
            }
            Phone temp = phones[index];
            phones[index] = phones[i];
            phones[i] = temp;
        }
    }

    static void sortAPPByAmount(appliances[] appliancesa, SortDirection sortDirection) {
        for (int i = 0; i < appliancesa.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < appliancesa.length; j++) {

                if (sortDirection == SortDirection.ASC) {
                    if (appliancesa[j].amountAPP < appliancesa[index].amountAPP) {
                        index = j;
                    }
                } else if (sortDirection == SortDirection.DESC) {
                    if (appliancesa[j].amountAPP > appliancesa[index].amountAPP) {
                        index = j;
                    }
                }
            }
            appliances temp = appliancesa[index];
            appliancesa[index] = appliancesa[i];
            appliancesa[i] = temp;
        }
    }

    static void sortACCByAmount(accessories[] accessoriess, SortDirection sortDirection) {
        for (int i = 0; i < accessoriess.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < accessoriess.length; j++) {

                if (sortDirection == SortDirection.ASC) {
                    if (accessoriess[j].amountACC < accessoriess[index].amountACC) {
                        index = j;
                    }
                } else if (sortDirection == SortDirection.DESC) {
                    if (accessoriess[j].amountACC > accessoriess[index].amountACC) {
                        index = j;
                    }
                }
            }
            accessories temp = accessoriess[index];
            accessoriess[index] = accessoriess[i];
            accessoriess[i] = temp;
        }
    }
    //endregion

    //region save to TXT file
    static void savePhonesToTxtFile(String filename, Phone[] phones) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(Integer.toString(phones.length));
        bufferedWriter.newLine();

        for (int i = 0; i < phones.length; i++) {
            bufferedWriter.write(Integer.toString(phones[i].id));
            bufferedWriter.newLine();

            bufferedWriter.write(phones[i].model);
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(phones[i].price));
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(phones[i].amount));
            bufferedWriter.newLine();
        }
        bufferedWriter.write(Integer.toString(lastPhoneId));
        bufferedWriter.newLine();


        bufferedWriter.close();
        fileWriter.close();

        System.out.println("Сохранение совершено успешно!");
    }

    static void saveAPPToTxtFile(String filenameAPP, appliances[] appliancesa) throws IOException {
        FileWriter fileWriter = new FileWriter(filenameAPP);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(Integer.toString(appliancesa.length));
        bufferedWriter.newLine();

        for (int i = 0; i < appliancesa.length; i++) {
            bufferedWriter.write(Integer.toString(appliancesa[i].idAPP));
            bufferedWriter.newLine();

            bufferedWriter.write(appliancesa[i].modelAPP);
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(appliancesa[i].priceAPP));
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(appliancesa[i].amountAPP));
            bufferedWriter.newLine();
        }
        bufferedWriter.write(Integer.toString(lastIdAppliances));
        bufferedWriter.newLine();


        bufferedWriter.close();
        fileWriter.close();

        System.out.println("Сохранение совершено успешно!");
    }

    static void saveACCToTxtFile(String filenameACC, accessories[] accessoriess) throws IOException {
        FileWriter fileWriter = new FileWriter(filenameACC);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(Integer.toString(accessoriess.length));
        bufferedWriter.newLine();

        for (int i = 0; i < accessoriess.length; i++) {
            bufferedWriter.write(Integer.toString(accessoriess[i].idACC));
            bufferedWriter.newLine();

            bufferedWriter.write(accessoriess[i].modelACC);
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(accessoriess[i].priceACC));
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(accessoriess[i].amountACC));
            bufferedWriter.newLine();
        }
        bufferedWriter.write(Integer.toString(lastACCId));
        bufferedWriter.newLine();


        bufferedWriter.close();
        fileWriter.close();

        System.out.println("Сохранение совершено успешно!");
    }
    //endregion

    //region load from TXT file
    static Phone[] loadPhonesFromTxtFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int phonesLength = Integer.parseInt(bufferedReader.readLine());
        Phone[] phones = new Phone[phonesLength];

        for (int i = 0; i < phones.length; i++) {
            int id = Integer.parseInt(bufferedReader.readLine());
            String model = bufferedReader.readLine();
            int price = Integer.parseInt(bufferedReader.readLine());
            int amount = Integer.parseInt(bufferedReader.readLine());

            phones[i] = new Phone(id, model, price, amount);
        }

        lastPhoneId = Integer.parseInt(bufferedReader.readLine());

        bufferedReader.close();
        fileReader.close();

        System.out.println("Загрузка совершена успешно!");

        return phones;
    }

    static appliances[] loadAPPFromTxtFile(String filenameAPP) throws IOException {
        FileReader fileReader = new FileReader(filenameAPP);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int phonesLength = Integer.parseInt(bufferedReader.readLine());
        appliances[] appliancesa = new appliances[phonesLength];

        for (int i = 0; i < appliancesa.length; i++) {
            int idAPP = Integer.parseInt(bufferedReader.readLine());
            String modelAPP = bufferedReader.readLine();
            int priceAPP = Integer.parseInt(bufferedReader.readLine());
            int amountAPP = Integer.parseInt(bufferedReader.readLine());

            appliancesa[i] = new appliances(idAPP, modelAPP, priceAPP, amountAPP);
        }

        lastIdAppliances = Integer.parseInt(bufferedReader.readLine());

        bufferedReader.close();
        fileReader.close();

        System.out.println("Загрузка совершена успешно!");

        return appliancesa;
    }

    static accessories[] loadACCFromTxtFile(String filenameACC) throws IOException {
        FileReader fileReader = new FileReader(filenameACC);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int phonesLength = Integer.parseInt(bufferedReader.readLine());
        accessories[] accessoriess = new accessories[phonesLength];

        for (int i = 0; i < accessoriess.length; i++) {
            int idACC = Integer.parseInt(bufferedReader.readLine());
            String modelACC = bufferedReader.readLine();
            int priceACC = Integer.parseInt(bufferedReader.readLine());
            int amountACC = Integer.parseInt(bufferedReader.readLine());

            accessoriess[i] = new  accessories(idACC, modelACC, priceACC, amountACC);
        }

        lastACCId = Integer.parseInt(bufferedReader.readLine());

        bufferedReader.close();
        fileReader.close();

        System.out.println("Загрузка совершена успешно!");

        return accessoriess;
    }
    //endregion

    //region print to TXT file
    static void printPhonesToTxtFile(String filename, Phone[] phones) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(String.format("%-3s%-12s%-8s%-18s", "ИД", "Модель", "Цена", "Остаток на складе"));
        bufferedWriter.newLine();

        if (phones.length == 0) {
            bufferedWriter.write("Список телефонов пуст");
            bufferedWriter.newLine();
        } else {
            for (int i = 0; i < phones.length; i++) {
                bufferedWriter.write(String.format("%-3d%-12s%-8d%-18d", phones[i].id, phones[i].model, phones[i].price, phones[i].amount));
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Список телефонов насчитывает " + phones.length + " элем.");
        }

        bufferedWriter.close();
        fileWriter.close();

        System.out.println("Печать в файл совершена успешно!");
    }

    static void printAPPToTxtFile(String filenameAPP, appliances[] appliancesa) throws IOException {
        FileWriter fileWriter = new FileWriter(filenameAPP);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(String.format("%-3s%-12s%-8s%-18s", "ИД", "Модель", "Цена", "Остаток на складе"));
        bufferedWriter.newLine();

        if (appliancesa.length == 0) {
            bufferedWriter.write("Список телефонов пуст");
            bufferedWriter.newLine();
        } else {
            for (int i = 0; i < appliancesa.length; i++) {
                bufferedWriter.write(String.format("%-3d%-12s%-8d%-18d", appliancesa[i].idAPP, appliancesa[i].modelAPP, appliancesa[i].priceAPP, appliancesa[i].amountAPP));
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Список телефонов насчитывает " + appliancesa.length + " элем.");
        }

        bufferedWriter.close();
        fileWriter.close();

        System.out.println("Печать в файл совершена успешно!");
    }

    static void printACCToTxtFile(String filenameACC, accessories[] accessoriess) throws IOException {
        FileWriter fileWriter = new FileWriter(filenameACC);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(String.format("%-3s%-12s%-8s%-18s", "ИД", "Модель", "Цена", "Остаток на складе"));
        bufferedWriter.newLine();

        if (accessoriess.length == 0) {
            bufferedWriter.write("Список телефонов пуст");
            bufferedWriter.newLine();
        } else {
            for (int i = 0; i < accessoriess.length; i++) {
                bufferedWriter.write(String.format("%-3d%-12s%-8d%-18d", accessoriess[i].idACC, accessoriess[i].modelACC, accessoriess[i].priceACC, accessoriess[i].amountACC));
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Список телефонов насчитывает " + accessoriess.length + " элем.");
        }

        bufferedWriter.close();
        fileWriter.close();

        System.out.println("Печать в файл совершена успешно!");
    }
//endregion

    //region println
    static void printlnTableHeader() {
        System.out.println(String.format("%-3s%-12s%-8s%-18s", "ИД", "Модель", "Цена", "Остаток на складе"));
    }


    static void printlnPhone(Phone phone) {
        System.out.println(String.format("%-3d%-12s%-8d%-18d", phone.id, phone.model, phone.price, phone.amount));
    }

    static void printlnAPP(appliances appliances) {
        System.out.println(String.format("%-3d%-12s%-8d%-18d", appliances.idAPP, appliances.modelAPP, appliances.priceAPP, appliances.amountAPP));
    }

    static void printlnACC(accessories accessories) {
        System.out.println(String.format("%-3d%-12s%-8d%-18d", accessories.idACC, accessories.modelACC, accessories.priceACC, accessories.amountACC));
    }
    //endregion

    //region println2
    static void printlnPhones(Phone[] phones) {
        if (phones.length == 0) {
            System.out.println("Список телефонов пуст");
            return;
        }

        for (int i = 0; i < phones.length; i++) {
            printlnPhone(phones[i]);
        }
        System.out.println("Список товаров насчитывает " + phones.length + " элем.");
    }

    static void printlnAPP(appliances[] appliancesa) {
        if (appliancesa.length == 0) {
            System.out.println("Список товаров пуст");
            return;
        }

        for (int i = 0; i < appliancesa.length; i++) {
            printlnAPP(appliancesa[i]);
        }
        System.out.println("Список товаров насчитывает " + appliancesa.length + " элем.");
    }

    static void printlnACC(accessories[] accessoriess) {
        if (accessoriess.length == 0) {
            System.out.println("Список товаров пуст");
            return;
        }

        for (int i = 0; i < accessoriess.length; i++) {
            printlnACC(accessoriess[i]);
        }
        System.out.println("Список товаров насчитывает " + accessoriess.length + " элем.");
    }
    //endregion
    static void printlnSeparator() {
        System.out.println("-".repeat(15));
    }
    static void printlnMenu() {
        System.out.println("Меню");
        System.out.println("1. Добавить новый товар");
        System.out.println("2. Сохранить товары в текстовый файл");
        System.out.println("3. Загрузить товары из текстового файла");
        System.out.println("4. Осуществить продажу товара");
        System.out.println("5. Удалить товар из списка");
        System.out.println("6. Распечатать список товаров в файл");
        System.out.println("7. Обновить данные о товаре");
        System.out.println("8. Найти товары в заданном ценовом диапазоне");
        System.out.println("9. Отсортировать товары по остатку на складе");
        System.out.println("0. Выйти из программы");
    }


    public static void main(String[] args) throws IOException {
        Phone[] phones = createEmptyPhonesArray();
        appliances[] appliancesa = createEmptyAppliancesArray();
        accessories[] accessoriess = createEmptyACCArray();

        while (true) {
            printlnTableHeader();
            printlnPhones(phones);
            printlnSeparator();
            printlnTableHeader();
            printlnAPP(appliancesa);
            printlnSeparator();
            printlnTableHeader();
            printlnACC(accessoriess);
            printlnSeparator();
            printlnMenu();
            int menuPoint = inputInt("Введите номер нужного пункта меню: ", 0, 9);

            switch (menuPoint) {
                case 1: {
                    System.out.println("1.бытовая техника");
                    System.out.println("2.серверное оборудование");
                    System.out.println("3.комплектующие для пк");
                    int gas = inputInt("Введите нужную цифру", 1, 3);

                    switch (gas){
                        case 1:{
                            Phone insertedPhone = createPhone();

                            lastPhoneId++;
                            insertedPhone.id = lastPhoneId;

                            phones = addPhoneToEndOfArray(phones, insertedPhone);

                            System.out.println("Товар добавлен успешно!");
                        }
                        break;

                        case 2:{

                            appliances insertAppliances = createAppliances();

                            lastIdAppliances++;
                            insertAppliances.idAPP = lastIdAppliances;

                            appliancesa = addAPPtoEndOfArray(appliancesa, insertAppliances);

                            System.out.println("Товар добавлен успешно!");
                        }
                        break;

                        case 3:{
                            accessories insertACC = createACC();

                            lastACCId++;
                            insertACC.idACC = lastACCId;

                            accessoriess = addACCToEndOfArray(accessoriess, insertACC);

                            System.out.println("Товар добавлен успешно!");
                        }
                        break;
                    }
                }
                break;

                case 2: {
                    System.out.println("1.бытовая техника");
                    System.out.println("2.серверное оборудование");
                    System.out.println("3.комплектующие для пк");

                    int pizda = inputInt("Введите нужную цифру", 1, 3);

                    switch (pizda){
                        case 1:{
                            String filename = inputString("Введите имя файла: ");

                            savePhonesToTxtFile(filename, phones);
                        }
                        break;

                        case 2:{
                            String filenameAPP = inputString("Введите имя файла: ");

                            saveAPPToTxtFile(filenameAPP, appliancesa);
                        }
                        break;

                        case 3:{
                            String filenameACC = inputString("Введите имя файла: ");

                            saveACCToTxtFile(filenameACC, accessoriess);
                        }
                        break;
                    }
                }
                break;

                case 3: {//
                    System.out.println("1.бытовая техника");
                    System.out.println("2.серверное оборудование");
                    System.out.println("3.комплектующие для пк");

                    int xyu = inputInt("Введите нужную цифру", 1, 3);
                    switch (xyu){
                        case 1:{
                            String filename = inputString("Введите имя файла: ");

                            phones = loadPhonesFromTxtFile(filename);
                        }
                        break;

                        case 2:{
                            String filenameAPP = inputString("Введите имя файла: ");

                            appliancesa = loadAPPFromTxtFile(filenameAPP);
                        }
                        break;

                        case 3:{
                            String filenameACC = inputString("Введите имя файла: ");

                            accessoriess = loadACCFromTxtFile(filenameACC);
                        }
                        break;
                    }
                }
                break;

                case 4: {

                    System.out.println("1.бытовая техника");
                    System.out.println("2.серверное оборудование");
                    System.out.println("3.комплектующие для пк");

                    int sqr = inputInt("Введите нужную цифру", 1, 3);
                    switch (sqr){
                        case 1:{
                            int soldIdPhone = inputInt("Введите ID товара для покупки: ", 1, lastPhoneId);
                            phones = sellPhone(phones, soldIdPhone);
                        }
                        break;

                        case 2:{
                            int soldIdAPP = inputInt("Введите ID товара для покупки: ", 1, lastIdAppliances);
                            appliancesa = sellAPP(appliancesa, soldIdAPP);
                        }
                        break;

                        case 3:{
                            int soldIdAPP = inputInt("Введите ID товара для покупки: ", 1, lastACCId);
                            accessoriess = sellACC(accessoriess, soldIdAPP);
                        }
                        break;
                    }
                }
                break;

                case 5: {
                    System.out.println("1.бытовая техника");
                    System.out.println("2.серверное оборудование");
                    System.out.println("3.комплектующие для пк");

                    int sqr = inputInt("Введите нужную цифру", 1, 3);
                    switch (sqr){
                        case 1:{
                            int deletedIdPhone = inputInt("Введите ID телефона для удаления : ", 1, lastPhoneId);
                            phones = deletePhoneById(phones, deletedIdPhone);
                        }
                        break;

                        case 2:{
                            int deletedIdPhone = inputInt("Введите ID телефона для удаления : ", 1, lastIdAppliances);
                            appliancesa = deleteAPPById(appliancesa, deletedIdPhone);
                        }
                        break;

                        case 3:{
                            int deletedIdPhone = inputInt("Введите ID телефона для удаления : ", 1, lastACCId);
                            accessoriess = deleteACCById(accessoriess, deletedIdPhone);
                        }
                        break;
                    }
                }
                break;

                case 6: {
                    System.out.println("1.бытовая техника");
                    System.out.println("2.серверное оборудование");
                    System.out.println("3.комплектующие для пк");

                    int sqr = inputInt("Введите нужную цифру", 1, 3);
                    switch (sqr){
                        case 1:{
                            String filename = inputString("Введите имя файла: ");

                            printPhonesToTxtFile(filename, phones);
                        }
                        break;

                        case 2:{
                            String filenameAPP = inputString("Введите имя файла: ");

                            printAPPToTxtFile(filenameAPP, appliancesa);
                        }
                        break;

                        case 3:{
                            String filenameASS = inputString("Введите имя файла: ");

                            printACCToTxtFile(filenameASS, accessoriess);
                        }
                        break;
                    }
                }
                break;

                case 7: {
                    System.out.println("1.бытовая техника");
                    System.out.println("2.серверное оборудование");
                    System.out.println("3.комплектующие для пк");

                    int sqr = inputInt("Введите нужную цифру", 1, 3);
                    switch (sqr){
                        case 1:{
                            int updatedIdPhone = inputInt("Введите ID телефона для обновления : ", 1, lastPhoneId);
                            updatePhoneById(phones, updatedIdPhone);
                        }
                        break;

                        case 2:{
                            int updatedIdPhone = inputInt("Введите ID телефона для обновления : ", 1, lastIdAppliances);
                            updateAPPById(appliancesa, updatedIdPhone);
                        }
                        break;

                        case 3:{
                            int updatedIdPhone = inputInt("Введите ID телефона для обновления : ", 1, lastACCId);
                            updateACCById(accessoriess, updatedIdPhone);
                        }
                        break;
                    }
                }
                break;

                case 8: {
                    System.out.println("1.бытовая техника");
                    System.out.println("2.серверное оборудование");
                    System.out.println("3.комплектующие для пк");

                    int sqr = inputInt("Введите нужную цифру", 1, 3);
                    switch (sqr){
                        case 1:{
                            int minPrice = inputInt("Введите минимальную цену телефона: ", 1, 1000000);
                            int maxPrice = inputInt("Введите максимальную цену телефона: ", 1, 1000000);
                            Phone[] foundPhones = findPhonesByPrice(phones, minPrice, maxPrice);

                            printlnTableHeader();
                            printlnPhones(foundPhones);
                        }
                        break;

                        case 2:{
                            int minPrice = inputInt("Введите минимальную цену телефона: ", 1, 1000000);
                            int maxPrice = inputInt("Введите максимальную цену телефона: ", 1, 1000000);
                            appliances[] foundPhones = findAPPByPrice(appliancesa, minPrice, maxPrice);

                            printlnTableHeader();
                            printlnAPP(foundPhones);
                        }
                        break;

                        case 3:{
                            int minPrice = inputInt("Введите минимальную цену телефона: ", 1, 1000000);
                            int maxPrice = inputInt("Введите максимальную цену телефона: ", 1, 1000000);
                            accessories[] foundPhones = findACCByPrice(accessoriess, minPrice, maxPrice);

                            printlnTableHeader();
                            printlnACC(foundPhones);
                        }
                        break;
                    }
                }
                break;

                case 9: {
                    System.out.println("1.бытовая техника");
                    System.out.println("2.серверное оборудование");
                    System.out.println("3.комплектующие для пк");

                    int sqr = inputInt("Введите нужную цифру", 1, 3);
                    switch (sqr){
                        case 1:{
                            int sortDirection = inputInt("Введите направление сортировки(0 - по возрастанию, 1 - по убыванию): ", 0, 1);

                            sortPhonesByAmount(phones, SortDirection.values()[sortDirection]);
                        }
                        break;

                        case 2:{
                            int sortDirection = inputInt("Введите направление сортировки(0 - по возрастанию, 1 - по убыванию): ", 0, 1);

                            sortAPPByAmount(appliancesa, SortDirection.values()[sortDirection]);
                        }
                        break;

                        case 3:{
                            int sortDirection = inputInt("Введите направление сортировки(0 - по возрастанию, 1 - по убыванию): ", 0, 1);

                            sortACCByAmount(accessoriess, SortDirection.values()[sortDirection]);
                        }
                        break;
                    }
                }
                break;

                case 0: {
                    System.exit(0);
                }
                break;
            }
        }
    }
}