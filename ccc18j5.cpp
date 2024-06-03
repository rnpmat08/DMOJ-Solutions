#include <iostream>
#include <queue>

using namespace std;

vector<int> B[10001];
bool V[10001];
int D[10001];

int main() {
    int N, M, P; cin >> N;
    vector<int> E;
    for (int i = 1; i <= N; i++) {
        cin >> M;
        for (int j = 0; j < M; j++) {
            cin >> P;
            B[i].push_back(P);
        }
        if (M == 0) E.push_back(i);
    }
    queue<int> Q;
    Q.push(1); V[1] = true; D[1] = 1;
    while (!Q.empty()) {
        int C = Q.front();
        Q.pop();
        for (int i : B[C]) {
            if (!V[i]) {
                V[i] = true;
                Q.push(i);
                D[i] = D[C] + 1;
            }
        }
    }
    int A = 1e+5;
    bool R = true;
    for (int i = 1; i <= N; i++) {
        if (!V[i]) {
            R = false;
            break;
        }
    }
    for (int j : E) if (D[j] > 1 && D[j] < A) A = D[j];
    cout << (R ? "Y" : "N");
    cout << "\n" << A;
    return 0;
}
