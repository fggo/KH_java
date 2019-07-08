public class Hanoi{
    //A -> C
    public void towerOfHanoi(int n){
        if(n == 1)
            System.out.println("MOVING disk " + n + " from A to C");
        else
            towerOfHanoi(n-1);
    }
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.towerOfHanoi(10);
    }
}