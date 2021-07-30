package tp1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class clientInfo {
    String name;
    String adress;
    String phone;

    public clientInfo(String n, String a, String p) {
        name = n;
        adress = a;
        phone = p;
    }
}

class productInfo {
    String name;
    String description;
    String value;
    String profit;
    String inventory;


    public productInfo(String n, String d, String v, String p, String i) {
        name = n;
        description = d;
        value = v;
        profit = p;
        inventory = i;
    }
}

public class Main {

    static ArrayList<clientInfo> clients = new ArrayList<>();
    static ArrayList<productInfo> products = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    static void menu() {

        System.out.println("|~~~~~~~~~~~~~~~MENU~~~~~~~~~~~~~~~|");
        System.out.println("| 1 - Cadastro de novo cliente     |");
        System.out.println("| 2 - Busca por cliente            |");
        System.out.println("| 3 - Cadastro de novo produto     |");
        System.out.println("| 4 - Busca por produto            |");
        System.out.println("| 5 - Cadastro de venda            |");
        System.out.println("| 6 - Mostrar produtos em estoque  |");
        System.out.println("| 7 - Sair                         |");
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");

        System.out.print("User: ");

    }

    static void addClient() {
        int numberOfClients, i;
        String name, adress, phone;

        System.out.print("Digite o número de Clientes que deseja adicionar: ");
        Scanner input = new Scanner(System.in);
        numberOfClients = input.nextInt();
        input.nextLine();

        for(i=0; i< numberOfClients; i++) {

            System.out.println("| Cliente " + (i + 1) + " |");
            System.out.print("Digite o nome do Cliente: ");
            name = input.nextLine();
            System.out.print("Digite o endereço do Cliente: ");
            adress = input.nextLine();
            System.out.print("Digite o número de telefone do Cliente: ");
            phone = input.nextLine();
            clients.add(new clientInfo(name, adress, phone));
        }
        System.out.println("Clientes adicionados com sucesso!");

    }

    static void showClients() {
        System.out.println("―――――――――――――――");
        for(int i = 0; i<clients.size(); i++) {
            System.out.println("Cliente " + (i+1) + ": " + clients.get(i).name);
        }
        System.out.println("―――――――――――――――");
    }

    static int findClient() {
        String clientName;
        int position = -1;
        System.out.print("Escolha um Cliente: ");
        clientName = input.nextLine();

        for(int i = 0; i < clients.size(); i++) {
            if (Objects.equals(clientName, clients.get(i).name)) {
                position= i;
            }
        }
        return position;
    }

    static void changeClientInfo() {
        String newName, newAdress, newPhone;
        int menuNum, selectedClient;

        selectedClient = findClient();

        if(selectedClient == -1) {
            System.out.println("Cliente não encontrado!");
        } else {
            do {
                //Menu do Cliente
                System.out.println("Cliente encontrado! Você deseja alterar algum dado?");
                System.out.println("――――――――――――――――――――――――――――――――");
                System.out.println("1 - Nome: " + clients.get(selectedClient).name);
                System.out.println("2 - Endereço: " + clients.get(selectedClient).adress);
                System.out.println("3 - Telefone: " + clients.get(selectedClient).phone);
                System.out.println("4 - Voltar para o Menu Principal");
                System.out.println("――――――――――――――――――――――――――――――――");

                System.out.print("User: ");
                menuNum = input.nextInt();
                input.nextLine();
                switch (menuNum) {
                    case 1:
                        System.out.print("Digite o novo nome: ");
                        newName = input.nextLine();
                        clients.get(selectedClient).name = newName;
                        break;
                    case 2:
                        System.out.print("Digite o novo endereço: ");
                        newAdress = input.nextLine();
                        clients.get(selectedClient).adress = newAdress;
                        break;
                    case 3:
                        System.out.print("Digite o novo telefone: ");
                        newPhone = input.nextLine();
                        clients.get(selectedClient).phone = newPhone;
                        break;
                    case 4:
                        System.out.print("");
                        break;
                    default:
                        System.out.println("O número que você digitou é inválido. Digite um número de 1 à 4.");
                }
            } while (menuNum < 1 || menuNum > 4);
        }
    }

    static void addProduct() {
        int numberOfProducts, i;
        String name, description, value, profit, inventory;

        System.out.print("Digite o número de produtos que deseja adicionar: ");
        Scanner input = new Scanner(System.in);
        numberOfProducts = input.nextInt();
        input.nextLine();

        for(i=0; i< numberOfProducts; i++) {

            System.out.println("| Produto " + (i + 1) + " |");
            System.out.print("Digite o nome do produto: ");
            name = input.nextLine();
            System.out.print("Digite a descrição do produto: ");
            description = input.nextLine();
            System.out.print("Digite o valor do produto: ");
            value = input.nextLine();
            System.out.print("Digite a porcentagem de lucro do produto: ");
            profit = input.nextLine();
            System.out.print("Quantidade em estoque: ");
            inventory = input.nextLine();

            products.add(new productInfo(name, description, value, profit, inventory));
        }
    }

    static void showProducts() {
        System.out.println("―――――――――――――――――――――");
        for(int i = 0; i<products.size(); i++) {
            System.out.print("Produto " + (i+1) + ": " + products.get(i).name + " | ");
            System.out.println("Estoque: " + products.get(i).inventory);
        }
        System.out.println("―――――――――――――――――――――");
    }

    static int findProduct() {
        int position = -1;
        String productName;

        System.out.print("Escolha um produto: ");
        productName = input.nextLine();

        for(int i = 0; i < products.size(); i++) {
            if (Objects.equals(productName, products.get(i).name)) {
                position = i;
            }
        }
        return position;
    }

    static void changeProductInfo() {
        String newProduct, newDescription, newValue, newProfit, newInventory;
        int menuNum, selectedProduct;

        selectedProduct = findProduct();
        if (selectedProduct == -1) {
            System.out.println("Produto não encontrado!");
        } else {
            do {
                //Menu do produto
                System.out.println("Produto encontrado! Você deseja alterar algum dado?");
                System.out.println("――――――――――――――――――――――――――――――――");
                System.out.println("1 - Nome: " + products.get(selectedProduct).name);
                System.out.println("2 - Descrição: " + products.get(selectedProduct).description);
                System.out.println("3 - Valor: " + products.get(selectedProduct).value);
                System.out.println("4 - Porcentagem de lucro: " + products.get(selectedProduct).profit);
                System.out.println("5 - Estoque: " + products.get(selectedProduct).inventory);
                System.out.println("6 - Voltar para o Menu Principal");
                System.out.println("――――――――――――――――――――――――――――――――");

                System.out.print("User: ");
                menuNum = input.nextInt();
                input.nextLine();
                switch (menuNum) {
                    case 1:
                        System.out.print("Digite o novo nome: ");
                        newProduct = input.nextLine();
                        products.get(selectedProduct).name = newProduct;
                        break;
                    case 2:
                        System.out.print("Digite a nova descrição: ");
                        newDescription = input.nextLine();
                        products.get(selectedProduct).description = newDescription;
                        break;
                    case 3:
                        System.out.print("Digite o novo valor: ");
                        newValue = input.nextLine();
                        products.get(selectedProduct).value = newValue;
                        break;
                    case 4:
                        System.out.print("Digite a nova porcentagem de lucro: ");
                        newProfit = input.nextLine();
                        products.get(selectedProduct).profit = newProfit;
                        break;
                    case 5:
                        System.out.print("Digite o novo estoque: ");
                        newInventory = input.nextLine();
                        products.get(selectedProduct).inventory = newInventory;
                        break;
                    case 6:
                        System.out.print("");
                        break;
                    default:
                        System.out.println("O número que você digitou é inválido. Digite um número de 1 à 6.");
                }
            } while (menuNum < 1 || menuNum > 6);
        }
    }

    static void sellRegister() {
        int numMenu = 0, amount, selectedClient, selectedProduct, newInventory;


        showClients();
        selectedClient = findClient();

        if(selectedClient == -1) {
            System.out.println("Cliente não encontrado!");

        } else {
            do {
                showProducts();
                selectedProduct = findProduct();

                if(selectedProduct == -1) {
                    System.out.println("Produto não encontrado!");

                } else {
                    System.out.println("Digite a quantidade à ser vendida: ");
                    amount = input.nextInt();

                    newInventory = Integer.parseInt(products.get(selectedProduct).inventory) - amount;
                    products.get(selectedProduct).inventory = String.valueOf(newInventory);

                    System.out.println("Deseja continuar cadastrando vendas para esse cliente?");
                    System.out.println("1 - SIM");
                    System.out.println("2 - NÃO");
                    System.out.print("User: ");
                    numMenu = input.nextInt();
                }
            } while (numMenu != 2);
        }
    }

    static void showInventory() {
        int numMenu = 0;

        for(int i = 0; i<products.size(); i++) {
            System.out.print("Produto " + (i+1) + ": " + products.get(i).name + " | ");
            System.out.println("Estoque: " + products.get(i).inventory);
        }

        System.out.println("――――――――――――");
        System.out.println("1 - Menu Principal ");
        System.out.println("――――――――――――");
        System.out.print("User: ");

        while (numMenu != 1) {
            numMenu = input.nextInt();
            if(numMenu != 1) {
                System.out.print("Você deve digitar um número válido: ");
            }
        }
    }

    static void autoAddClientAndProduct() {
        String clientName, clientAdress, clientPhone;
        String productName, productDescription, productValue, productProfit, productInventory;
        int i;
        //adiciona clientes
        for(i = 0; i < 10; i++) {

            clientName = "cliente " + (i + 1);
            clientAdress = "casa " + (i + 1);
            clientPhone = "telefone " + (i + 1);
            clients.add( new clientInfo(clientName, clientAdress, clientPhone));

        }
        //adiciona produtos
        for(i = 0; i < 10; i++) {

            productName = "produto " + (i + 1);
            productDescription = "Apenas mais um produto";
            productValue = "" + (i + 1);
            productProfit = "50%";
            productInventory = "10";
            products.add( new productInfo(productName, productDescription, productValue, productProfit, productInventory));

        }
    }

    public static void main(String[] args) {
        int menuNum;

        autoAddClientAndProduct();
        do {
            menu();
            menuNum = input.nextInt();
            input.nextLine();
            switch (menuNum) {
                case 1:
                    addClient();
                    break;
                case 2:
                    changeClientInfo();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    changeProductInfo();
                    break;
                case 5:
                    sellRegister();
                    break;
                case 6:
                    showInventory();
                    break;
                case 7:
                    System.out.println("Saindo... Volte sempre!");
                    System.out.println("Autor: André Macedo Rodrigues Alves");
                    System.out.println("Instituição: UnB");
                    System.out.println("Data: 30/07/2021");
                    break;
                default:
                    System.out.println("Você deve digitar um número válido.");
            }
        } while (menuNum != 7);


    }
}

