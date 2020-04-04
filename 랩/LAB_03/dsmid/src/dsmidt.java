public class dsmidt {


    Binary search

    static int binary(int A[], int key)

    int L = -1, int R = A.length
    while(L+1 != R) {
        int i = (L+R)/2;
        if(key < A[i]) R = i;
        if (key == A[i]) return i;
        if (key > A[i]) L = i;
    }
    return A.length --> key not found;
}