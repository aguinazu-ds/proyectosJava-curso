public class App {
    public static void main(String[] args) throws Exception {
        // Ternas pitagoricas para probar (3,4,5), (5,12,13), (7,24,25), (8,15,17), (9,40,41), (11,60,61)
        int catetoA = 11;
        int catetoB = 60;
        Pitagoras triangulo = new Pitagoras();
        double hipotenusa = triangulo.calcularHipotenusa(catetoA, catetoB);
        System.out.println(hipotenusa);
    }
}
