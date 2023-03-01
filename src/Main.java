import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int sizeFloor;
        int sizeRoom;
        do {
            System.out.println("=============Setting Up the Condo============");
            System.out.print("Enter the number of floor : ");
            sizeFloor=scanner.nextInt();
            if(sizeFloor < 1){
                System.out.println("FLOOR CANNOT BE ZERO OR NEGATIVE!");
            }else{
                System.out.print("Enter the number of room : ");
                sizeRoom=scanner.nextInt();
                if(sizeRoom<1){
                    System.out.println("ROOM CANNOT BE ZERO OR NEGATIVE!");
                }else{
                    System.out.println("====================================================");
                    System.out.println("===============your set up is success===============");
                    System.out.println("=>Number of Floor : "+sizeFloor+" floors");
                    System.out.println("=>Number of Room  : "+sizeRoom+" rooms");
                    System.out.println("Total Condo : "+(sizeFloor*sizeRoom)+" condos");
                    String [][]condo=new String[sizeFloor][sizeRoom];
                    do {
                        System.out.println("================Welcome to PP Cono===============");
                        System.out.println("1. Buy Condo");
                        System.out.println("2. Sell Condo");
                        System.out.println("3. Search Information");
                        System.out.println("4. Display Information");
                        System.out.println("5. Exit");
                        System.out.println("--------------------------------------------------");
                        System.out.print("=> Choose option from (1-5) : ");
                        int op1=scanner.nextInt();
                        switch (op1)
                        {
                            case 1:
                            {

                                do {
                                    int buyRoom,buyFloor;
                                    System.out.print("Enter your desired floor (1 - "+sizeFloor+") : ");
                                    buyFloor=scanner.nextInt();
                                    if(buyFloor > sizeFloor || buyFloor <0){
                                        System.out.println("       FLOOR RANG START 1-"+sizeFloor);
                                        System.out.println("Press Enter to continue...");
                                        scanner.nextLine();
                                        scanner.nextLine();
                                        break;
                                    }else{
                                        System.out.print("Enter your desired room (1 - "+sizeRoom+") : ");
                                        buyRoom=scanner.nextInt();
                                        if(buyRoom >sizeRoom || buyRoom <0){
                                            System.out.println("       ROOM RANG START 1-"+sizeRoom);
                                            System.out.println("Press Enter to continue...");
                                            scanner.nextLine();
                                            scanner.nextLine();
                                            break;
                                        }else{
                                            if(condo[buyFloor-1][buyRoom-1] != null){
                                                System.out.println("room  "+buyRoom+" floor "+buyFloor+" is has been bought by someone else already...");
                                                System.out.println("Press \" Enter \" to continue...");
                                                scanner.nextLine();
                                                scanner.nextLine();
                                                break;
                                            }else{
                                                System.out.print("Enter your name : ");
                                                scanner.nextLine();
                                                String name=scanner.nextLine();
                                                System.out.println("Name : "+name+" at room "+buyRoom+" floor "+buyFloor+"   buy successfully !!");
                                                condo[buyFloor-1][buyRoom-1]=name;
                                                break;
                                            }
                                        }
                                    }
                                }while (true);
                            }break;
                            case 2:
                            {
                                int roomSell,floorSell;
                                System.out.println("--------------Selling the Condo Back--------------");
                                do {
                                    System.out.print("Enter floor ( 1 - "+sizeFloor+" ) : ");
                                    floorSell=scanner.nextInt();
                                    if(floorSell > sizeFloor || floorSell <0){
                                        System.out.println("    floor start 1-"+sizeFloor);
                                        System.out.print("Press enter to continue...!");
                                        break;
                                    }else{
                                        System.out.print("Enter Room ( 1 - "+sizeRoom+" ) : ");
                                        roomSell=scanner.nextInt();
                                        if(roomSell > sizeRoom || roomSell <0){
                                            System.out.println("    room start 1-"+sizeRoom);
                                            System.out.print("Press enter to continue...!");
                                            break;
                                        }else{
                                            if(condo[floorSell-1][roomSell-1] == null) {
                                                System.out.println("CANNOT SELL THE CONDO, CAUSE YOU DON'T HAVE THE OWNERSHIP!");
                                                System.out.print("Press \"Enter\" to continue...");
                                                scanner.nextLine();
                                                scanner.nextLine();
                                                break;
                                            }else{
                                                System.out.println(">> Selected Condo Information : ");
                                                System.out.println("floor : "+floorSell +" room : "+roomSell +" belong to "+(condo[roomSell-1][floorSell-1]));
                                                System.out.println("Enter 1 to confirm and 0 to cancel : ");
                                                int val=scanner.nextInt();
                                                if(val==1){
                                                    System.out.println("CONGRATULATION !! YOU HAVE SUCCESSFULLY SELL YOUR CONDO");
                                                    condo[floorSell-1][roomSell-1]=null;
                                                    System.out.println("Press \"Enter\" to continue ...");
                                                    scanner.nextLine();
                                                    scanner.nextLine();
                                                    break;
                                                }else if(val==0){
                                                    break;
                                                }else{
                                                    System.out.println("Your input is not 1-2");
                                                    System.out.println("Press \"Enter\" to continue ...");
                                                    scanner.nextLine();
                                                    scanner.nextLine();
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }while (true);
                            }break;
                            case 3:
                            {
                                search:
                                do {
                                    System.out.println("=============Search Information==============");
                                    System.out.println("1. Search by owner's name");
                                    System.out.println("2. Search by floor");
                                    System.out.println("3. Exit");
                                    System.out.println("---------------------------------------------");
                                    System.out.print("=> Choose your option 1 - 3 : ");
                                    int val=scanner.nextInt();
                                    switch (val)
                                    {
                                        case 1:
                                        {
                                            boolean check=false;
                                            System.out.println("=============Search Condo by Owner's Name==============");
                                            System.out.print("Enter owner name to search : ");
                                            scanner.nextLine();
                                            String name=scanner.nextLine();
                                            for(int i=0;i<condo.length;i++){
                                                for(int j=0;j<condo[i].length;j++){
                                                    if(name.equals(condo[i][j])){
                                                        System.out.println("Owner name : "+name+" is stays in Room no : "+(i+1)+" floor no : "+(j+1));
                                                        check=true;
                                                    }
                                                }
                                            }
                                            if(!check){
                                                System.out.println("User: "+name+" doesn't exit in our condo system...!");
                                            }
                                        }break;
                                        case 2:
                                        {
                                            boolean check=false;
                                            System.out.println("=================Search Condo by Floor=================");
                                            System.out.print("Enter floor to search ( 1 - "+sizeFloor+" ): ");
                                            int floorSearch=scanner.nextInt();
                                            if(floorSearch > sizeFloor || floorSearch<0){
                                                System.out.println("Your input is incorrect , Floor start from 1-"+sizeFloor);
                                                System.out.println("Press \" Enter \" to continue");
                                                scanner.nextLine();
                                                scanner.nextLine();
                                            }else{
                                                for(int i=0;i<condo.length;i++){
                                                    for(int j=0;j<condo[i].length;j++){
                                                        if((floorSearch-1)==j){
                                                            System.out.print(!check?"Floor "+floorSearch+" : "+condo[i][j]+" ":condo[i][j]+" ");
                                                            check=true;
                                                        }
                                                    }
                                                }
                                                System.out.println();
                                            }
                                        }break;
                                        case 3:
                                        {
                                            break search;
                                        }
                                        default:
                                        {
                                            System.out.println("Your input is incorrect");
                                        }
                                    }
                                }while (true);
                            }break;
                            case 4:
                            {
                                for(int i= condo.length-1;i>=0;i--){
                                    System.out.print("floor ["+(i+1)+"] => ");
                                    for(int j=0;j<condo[i].length;j++){
                                        System.out.print(condo[i][j]+"   ");
                                    }
                                    System.out.println();
                                }
                            }break;
                            case 5:
                            {
                                System.exit(0);
                            }break;
                            default:{
                                System.out.println("Your input is incorrect try agin !!");
                            }
                        }
                    }while (true);
                }
            }
        }while (true);
    }
}