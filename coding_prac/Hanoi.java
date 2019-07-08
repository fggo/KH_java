public class Hanoi{
    //A -> C
    public void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod){
        if(n == 1)
            System.out.printf("MOVING disk %d from %c to %c\n", n, from_rod, to_rod); 
        else {
            towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
            System.out.printf("MOVING disk %d from %c to %c\n", n, from_rod, to_rod); 
            towerOfHanoi(n-1, aux_rod, to_rod, from_rod);
        }
    }
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.towerOfHanoi(4, 'A', 'C', 'B');
    }
}