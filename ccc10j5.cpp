#include <iostream>
#include <queue>

using namespace std;

int G[9][9], dir[8][2] = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
bool V[9][9];

int main() {
    int SR, SC, ER, EC; cin >> SR >> SC >> ER >> EC;
    queue<pair<int, int>> Q; Q.push({SR, SC}); V[SR][SC] = true; G[SR][SC] = 0;
    while (!Q.empty()) {
        int R = Q.front().first, C = Q.front().second; Q.pop();
        for (int i = 0; i < 8; i++) {
            int NR = R + dir[i][0], NC = C + dir[i][1];
            if (NR <= 8 && NR > 0 && NC <= 8 && NC > 0 && !V[NR][NC]) {
                V[NR][NC] = true;
                G[NR][NC] = G[R][C] + 1;
                Q.push({NR, NC});
            }
        }
    }
    cout << G[ER][EC];
    return 0;
}