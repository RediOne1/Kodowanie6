public class FabrykaSchematow {

    public FabrykaSchematow(String filename) {
        LoadFile in = new LoadFile(filename);
        //SaveToFile out = new SaveToFile(in.getNaglowek(), in.getStopka());
        Pixels pixele = in.getPixelsMap();
        Entropia e = new Entropia(pixele);
        System.out.println("OBRAZ POCZATKOWY");
        System.out.println(" Color entropy	" + e.getColorsEntropy());
        System.out.println(" Red entropy	" + e.getRedEntropy());
        System.out.println(" Green entropy	" + e.getGreenEntropy());
        System.out.println(" Blue entropy	" + e.getBlueEntropy());
        MetodaPredykcyjna schemat[] = new MetodaPredykcyjna[9];
        schemat[1] = new Schemat1(pixele);
        schemat[2] = new Schemat2(pixele);
        schemat[3] = new Schemat3(pixele);
        schemat[4] = new Schemat4(pixele);
        schemat[5] = new Schemat5(pixele);
        schemat[6] = new Schemat6(pixele);
        schemat[7] = new Schemat7(pixele);
        schemat[8] = new Schemat8(pixele);
        //for (int i = 1; i < schemat.length; i++)
        //	out.save(schemat[i]);
    }
}
