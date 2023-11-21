import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int gold=-1, silver=-1, bronze=-1;
        int goldI = -1, silverI = -1, bronzeI = -1;
        int countryCnt[] = new int[101];

        class Student {
            int country;
            int num;
            int score;


            public Student(String country,String num, String score){
                this.country = Integer.parseInt(country);
                this.num = Integer.parseInt(num);
                this.score = Integer.parseInt(score);
            }
        }

        Vector<Student> students = new Vector<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            students.add(new Student(st.nextToken(), st.nextToken(), st.nextToken()));

            int score = students.get(i).score;
            int cnt = students.get(i).country;

            if(countryCnt[cnt]<2){
                if(score > gold){

                    if(silver!=-1){
                        if(bronze!=-1)
                            countryCnt[students.get(bronzeI).country]--;
                        bronze = silver;
                        bronzeI = silverI;

                    }
                    if(gold!=-1){
                        silver = gold;
                        silverI = goldI;
                    }
                    gold = score;
                    goldI = i;
                    countryCnt[cnt]++;

                }
                else if(score > silver){
                    if(silver!=-1){
                        if(bronze!=-1)
                            countryCnt[students.get(bronzeI).country]--;
                        bronze = silver;
                        bronzeI = silverI;
                    }
                    silver = score;
                    silverI = i;
                    countryCnt[cnt]++;
                }
                else if(score > bronze){
                    if(bronze!=-1){
                        countryCnt[students.get(bronzeI).country]--;
                    }
                    bronze = score;
                    bronzeI = i;
                    countryCnt[cnt]++;
                }

            }

        }
        System.out.println(students.get(goldI).country+" "+students.get(goldI).num);
        System.out.println(students.get(silverI).country+" "+students.get(silverI).num);
        System.out.println(students.get(bronzeI).country+" "+students.get(bronzeI).num);
    }
}