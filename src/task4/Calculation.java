package task4;

class Calculation implements Runnable {
    private final Resource resource;

    public Calculation(final Resource resource) {
        this.resource = resource;
    }

    public void run() {
            int counter = 0;
            int num;
            //prints the number till specified number is reached, starting from 10
            do {
                num = counter + 10;
                System.out.println(Thread.currentThread().getName() + " prints " + num);
                counter++;
            } while (num != resource.number);
            System.out.println(Thread.currentThread().getName() + " printed " + counter + " times");
            try{
                Thread.sleep(100);
            }
            catch(final InterruptedException e){}
    }
}