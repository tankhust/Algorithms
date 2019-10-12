package 春招公司笔试20190310_20190515.basicClass;

import java.util.LinkedList;
import java.util.Queue;

public class Code_11_DogCatQueue {//猫狗队列

    public static class Pet {
        public String type;

        public Pet(String type) {
            this.type=type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet{
       public Cat() {
            super("cat");
        }
    }

    public static class PetEnterQueue {
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.getCount();
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }
    }

    public static class DogCatQueue {
        private Queue<PetEnterQueue> dogQueue;
        private Queue<PetEnterQueue> catQueue;
        private long count;

        public DogCatQueue() {
            dogQueue = new LinkedList<PetEnterQueue>();
            catQueue = new LinkedList<PetEnterQueue>();
            count = 0;
        }

        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                this.dogQueue.add(new PetEnterQueue(pet, this.count++));
            } else if (pet.getPetType().equals("cat")) {
                this.catQueue.add(new PetEnterQueue(pet, this.count++));
            }else{
                throw new RuntimeException("error,not a dog or a cat");
            }
        }

        public Pet pollAll() {
            if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
                if (this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()) {
                    return this.dogQueue.poll().getPet();
                }else{
                    return this.catQueue.poll().getPet();
                }
            } else if (!this.dogQueue.isEmpty()) {
                return this.dogQueue.poll().getPet();
            } else if (!this.catQueue.isEmpty()) {
                return this.catQueue.poll().getPet();
            } else {
                throw new RuntimeException("the queue is empty");
            }
        }

        public Pet pollDog() {
            if (!this.dogQueue.isEmpty()) {
                return this.dogQueue.poll().getPet();
            }else{
                throw new RuntimeException("Dog queue is empty");
            }
        }

        public Pet pollCat() {
            if (!this.catQueue.isEmpty()) {
                return this.catQueue.poll().getPet();
            }else{
                throw new RuntimeException("Dog queue is empty");
            }
        }

        public boolean isEmpty() {
            return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
        }

        public boolean isDogEmpty() {
            return this.dogQueue.isEmpty();
        }

        public boolean isCatEmpty() {
            return this.catQueue.isEmpty();
        }
    }


    public static void main(String[] args) {
        DogCatQueue test = new DogCatQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }



}
