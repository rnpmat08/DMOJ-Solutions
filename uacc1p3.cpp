#include <iostream>

using namespace std;
char B[8][8];
int dir[4][2] = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
int A = 0;

void DFS(int R, int C, int cap) {
    for (int i = 0; i < 4; i++) {
        int NR = R + dir[i][0], NC = C + dir[i][1], ER = NR + dir[i][0], EC = NC + dir[i][1];
        if (NR >= 0 && NR < 8 && NC >= 0 && NC < 8 && ER >= 0 && ER < 8 && EC >= 0 && EC < 8 && B[NR][NC] == 'B' && B[ER][EC] == '.') {
            B[NR][NC] = '.';
            A = max(A, cap + 1);
            DFS(ER, EC, cap + 1);
            B[NR][NC] = 'B';
        }
    }
}

int main() {
    for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++) cin >> B[i][j];
    for (int i = 0; i < 8; i++) for (int j = 0; j < 8; j++) if (B[i][j] == 'A') DFS(i, j, 0);
    cout << A;
    return 0;
}