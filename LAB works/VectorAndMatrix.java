
interface Pair {
    void add(Pair p);
    void product(Pair p);
}

class Vector implements Pair {
    private double[] vector;

    public Vector(double[] vector) {
        this.vector = vector;
    }

    public double[] getVector() {
        return vector;
    }

    void print(double[] vector){
        System.out.print("[ ");
        for(double x : vector){
            System.out.print(x + "  ");
        }
        System.out.println("]");
    }

    public void add(Pair obj) {
        double[] v1 = this.getVector();
        Vector v2  = (Vector)obj;

        if(v1.length != v2.vector.length){
            System.out.println("length should be same");
        }
        else{
            double[] addition = new double[v1.length];
            for (int i = 0; i < v1.length; i++) {
                addition[i] = v1[i] + v2.vector[i];
            }

            System.out.print("Sum of vectors: ");
            this.print(addition);
        }
    }

    public void product(Pair obj) {
        double[] v1 = this.getVector();
        Vector v2  = (Vector)obj;

        if(v1.length != v2.vector.length){
            System.out.println("length should be same");
        }
        else{
            double product = 0.0;
            for (int i = 0; i < v1.length; i++) {
                product += v1[i] * v2.vector[i];
            }
            
            System.out.println("Product of vectors: " + product);
        }
    }
}

class Matrix implements Pair {
    private double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    void print(double[][] mat1){
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                System.out.print(mat1[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public void add(Pair obj) {
        double[][] mat1 = this.getMatrix();
        Matrix mat2 = (Matrix)obj; 
        
        double[][] addition = new double[mat1.length][mat1[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                addition[i][j] = mat1[i][j] + mat2.matrix[i][j];
            }
        }

        System.out.println("\nSum of Matrices : ");
        this.print(addition);
    }

    public void product(Pair obj) {
        double[][] mat1 = this.getMatrix();
        Matrix mat2 = (Matrix)obj;

        if(mat1[0].length != mat2.matrix.length) {
            System.out.println("invalid matrices dimension");
        }
        else{        
            double[][] product = new double[mat1.length][mat2.matrix[0].length];
            for (int i = 0; i < mat1.length; i++) {
                for (int j = 0; j < mat2.matrix[0].length; j++) {
                    for (int k = 0; k < mat1[0].length; k++) {
                        product[i][j] += mat1[i][k] * mat2.matrix[k][j];
                    }
                }
            }
            
            System.out.println("\nProduct of Matrices : ");
            this.print(product);
        }
    }
}

public class VectorAndMatrix {
    public static void main(String[] args) {
        Vector v1 = new Vector(new double[] {1, 2, 3});
        Vector v2 = new Vector(new double[] {4, 5, 6});

        System.out.print("\nvector 1 : ");
        v1.print(v1.getVector());
        System.out.print("vector 2 : ");
        v1.print(v2.getVector());
        v1.add(v2);
        v1.product(v2);

        Matrix mat1 = new Matrix(new double[][] {{6,4,5},{4,3,6},{3,4,6}});
        Matrix mat2 = new Matrix(new double[][] {{4,6,1},{7,7,2},{9,7,8}});

        System.out.println("\nMatrix-1: ");
        mat1.print(mat1.getMatrix());
        System.out.println("\nMatrix-2: ");
        mat1.print(mat2.getMatrix());
        mat1.add(mat2);
        mat1.product(mat2);
    }
}