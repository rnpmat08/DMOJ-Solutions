#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

vector<int> G[50] = {{}, {6}, {6}, {4, 5, 6, 15}, {3, 5, 6}, {3, 4, 6}, {1, 2, 3, 4, 5, 7}, {6, 8}, {7, 9}, {8, 10, 12}, {9, 11}, {10, 12}, {9, 11, 13}, {12, 14, 15}, {13}, {3, 13}, {17, 18}, {16, 18}, {16, 17}};
bool V[50];
int D[50];

void dos(int x, int y) {
    queue<int> Q;
    memset(V, false, sizeof(V));
    V[x] = true; D[x] = 0; Q.push(x);
    while (!Q.empty()) {
        int C = Q.front();
        Q.pop();
        for (int i : G[C]) {
            if (!V[i]) {
                V[i] = true;
                Q.push(i);
                D[i] = D[C] + 1;
            }
        }
    }
    (D[y] == 0) ? cout << "Not connected\n" : cout << D[y] << "\n";
}

void fof(int x) {
    queue<int> Q;
    memset(V, false, sizeof(V));
    V[x] = true;
    for (int i : G[x]) {
        Q.push(i);
        V[i] = true;
    }
    int ans = 0;
    while (!Q.empty()) {
        int C = Q.front();
        Q.pop();
        for (int i : G[C]) {
            if (!V[i]) {
                V[i] = true;
                ans++;
            }
        }
    }
    cout << ans << "\n";
}

int main() {
    char C; cin >> C;
    while (C != 'q') {
        if (C == 'i') {
            int x, y; cin >> x >> y;
            G[x].push_back(y); G[y].push_back(x);
        } else if (C == 'd') {
            int x, y; cin >> x >> y;
            for (int i = 0; i < G[x].size(); i++) {
                if (G[x][i] == y) {
                    G[x].erase(G[x].begin() + i);
                    break;
                }
            }
        } else if (C == 'n') {
            int x; cin >> x;
            cout << G[x].size() << "\n";
        } else if (C == 'f') {
            int x; cin >> x;
            fof(x);
        } else if (C == 's') {
            int x, y; cin >> x >> y;
            dos(x, y);
        } else {
            break;
        }
        cin >> C;
    }
    return 0;
}