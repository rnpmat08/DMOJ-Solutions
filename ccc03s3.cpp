#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

char H[25][25];
int r, c;
int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

int BFS(int SR, int SC) {
    queue <pair<int, int>> Q;
    int S = 1;
    Q.push({SR, SC});
    H[SR][SC] = 'V';
    while (!Q.empty()) {
        int R = Q.front().first, C = Q.front().second;
        Q.pop();
        for (int i = 0; i < 4; i++) {
            int NR = R + dir[i][0], NC = C + dir[i][1];
            if (NR >= 0 && NR < r && NC >= 0 && NC < c && H[NR][NC] == '.') {
                H[NR][NC] = 'V';
                Q.push({NR, NC});
                S++;
            }
        }
    }
    return S;
}

int main() {
    int F, A = 0;
    vector <int> R;
    cin >> F >> r >> c;
    for (int i = 0; i < r; i++) {
        string S; cin >> S;
        for (int j = 0; j < c; j++) H[i][j] = S[j];
    }
    for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) if (H[i][j] == '.') R.push_back(BFS(i, j));
    sort(R.begin(), R.end()); reverse(R.begin(), R.end());
    for (int i : R) {
        if (F >= i) {
            F -= i;
            A++;
        } else {
            break;
        }
    }
    cout << A << ((A == 1) ? " room, " : " rooms, ") << F << " square metre(s) left over\n";
    return 0;
}