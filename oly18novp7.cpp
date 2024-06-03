#include <iostream>
#include <queue>

using namespace std;

int D[100001];
bool V[100001];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int X, Y; cin >> X >> Y;
    queue<int> Q; Q.push(X); V[X] = true; D[X] = 0;
    while (!V[Y]) {
        int C = Q.front(); Q.pop();
        if (C - 1 >= 0 && !V[C - 1]) {
            Q.push(C - 1);
            V[C - 1] = true;
            D[C - 1] = D[C] + 1;
        }
        if (C + 1 <= 100000 && !V[C + 1]){
            Q.push(C + 1);
            V[C + 1] = true;
            D[C + 1] = D[C] + 1;
        }
        if (2 * C <= 100000 && !V[2 * C]) {
            Q.push(2 * C);
            V[2 * C] = true;
            D[2 * C] = D[C] + 1;
        }
    }
    cout << D[Y] << "\n";
    return 0;
}