#include <iostream>

char P[2000][2000];
int n, m;

using namespace std;

void print() {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) cout << P[i][j];
        cout << "\n";
    }
}

int main() {
    int r, c; cin >> n >> m >> r >> c;
    if ((n == r && m % 2 == 0 && c % 2 == 1) || (m == c && n % 2 == 0 && r % 2 == 1)) {
        cout << "IMPOSSIBLE\n";
        return 0;
    }
    for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) P[i][j] = 'a';
    if (r == n && c != m) {
        for (int i = 0; i < m; i++) P[0][i] = 'b';
        if (c % 2 == 1) P[0][m / 2] = 'a';
        for (int i = 0; i < c / 2; i++) {
            P[0][i] = 'a';
            P[0][m - i - 1] = 'a';
        }
        print();
        return 0;
    } else if (c == m && r != n) {
        for (int i = 0; i < n; i++) P[i][0] = 'b';
        if (r % 2 == 1) P[n / 2][0] = 'a';
        for (int i = 0; i < r / 2; i++) {
            P[i][0] = 'a';
            P[n - i - 1][0] = 'a';
        }
        print();
        return 0;
    }
    if (n != r) for (int i = 0; i < n - r; i++) P[i][0] = 'b';
    if (m != c) for (int i = 0; i < m - c; i++) P[0][i] = 'b';
    if (n - r != 0 && m - c != 0) P[0][0] = 'c';
    print();
    return 0;
}