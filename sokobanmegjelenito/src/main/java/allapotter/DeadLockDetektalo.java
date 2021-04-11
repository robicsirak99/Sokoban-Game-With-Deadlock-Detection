package allapotter;

public class DeadLockDetektalo {

    public void detektalo(Allapot allapot){

        Allapot masolat = new Allapot(allapot);

        //az állapotból kiválasztunk egy dobozt
        int dobozszam = 0;
        for(int i = 0; i < masolat.allapot_tomb.length; i++) {
            for (int j = 0; j < masolat.allapot_tomb[0].length; j++) {
                if(masolat.allapot_tomb[i][j]==2){ //találtunk egy dobozt
                    dobozszam++;
                    //az összes többi dobozt fallá alakítjuk
                    for(int k = 0; k < masolat.allapot_tomb.length; k++) {
                        for (int l = 0; l < masolat.allapot_tomb[0].length; l++) {
                            //ha dobozt találunk és az a doboz nem a kiválasztott doboz akkor elvégezzük az átalakítást
                            if((masolat.allapot_tomb[k][l]==2) && !((i==k) && (j==l))){
                                masolat.allapot_tomb[k][l]=1;
                            }
                        }
                    }
                    //innen folytatjuk, egyenlőre megnézzük jó-e az eddigi kódrész
                    int db = 0;
                    for(int k = 0; k < masolat.allapot_tomb.length; k++) {
                        for (int l = 0; l < masolat.allapot_tomb[0].length; l++) {
                            //ha dobozt találunk és az a doboz nem a kiválasztott doboz akkor elvégezzük az átalakítást
                            if(masolat.allapot_tomb[k][l]==2){
                                db++;
                            }
                        }
                    }
                    if(db==1) System.out.println("EGY DARAB DOBOZT TALÁLUNK AZ ÁTALAKITÁS UTÁN");
                    else System.out.println("TÖBB DOBOZ BUG");
                }
            }
        }
        System.out.println("dobozszam"+ dobozszam);

    }


}
