#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

char H[50][50];
bool V[50][50];
int D[50][50], dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

int main() {
    int t, l, w, SR, SC, ER, EC; cin >> t; string s;
    for (int i = 0; i < t; i++) {
        cin >> l >> w;
        memset(V, false, sizeof(V));
        for (int j = 0; j < w; j++) {
            cin >> s;
            for (int k = 0; k < l; k++) {
                H[j][k] = s[k];
                if (s[k] == 'C') {
                    SR = j;
                    SC = k;
                }
                if (s[k] == 'W') {
                    ER = j;
                    EC = k;
                }
            }
        }
        queue<pair<int, int>> Q;
        Q.push({SR, SC});
        V[SR][SC] = true;
        D[SR][SC] = 0;
        while (!Q.empty()) {
            int R = Q.front().first, C = Q.front().second;
            Q.pop();
            for (int k = 0; k < 4; k++) {
                int NR = R + dir[k][0], NC = C + dir[k][1];
                if (NR >= 0 && NR < w && NC >= 0 && NC < l && H[NR][NC] != 'X' && !V[NR][NC]) {
                    Q.push({NR, NC});
                    V[NR][NC] = true;
                    D[NR][NC] = D[R][C] + 1;
                }
            }
        }
        cout << (V[ER][EC] && D[ER][EC] < 60 ? to_string(D[ER][EC]) : "#notworth") << "\n";
    }
    return 0;
}