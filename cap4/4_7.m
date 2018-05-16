% tabella di comodo per mostrare le stime dell'errore
Table = cell2table(cell(0,2));
Table.Properties.VariableNames = {'n' 'error'};

f = @(x) 1./(1 + x.^2);
a = -6;
b = 6;

n = 2;
while n <= 40

    xi = ceby(n, a, b); % ascisse di chebyshev
    fi = f(xi); % valutazioni fun di runge
    p = @(x) lagrange(xi, fi, x);

    % GRAFICO
    fplot(f, [a, b]) % per riferimento
    hold on
    fplot(p, [a, b])
    plot(xi, fi, 'r*') % evidenzio punti interp
    hold off
    print('-dpng', strcat(num2str(n), '.png'));

    % STIMA DELL'ERRORE
    x = linspace(a, b, 100001);
    e = norm(f(x) - p(x), inf);
    record = {n, e};
    Table = [Table; record];

    n = n + 2;
end

% mostra la tabella
uitable('Data',Table{:,:},'ColumnName',Table.Properties.VariableNames,...
    'RowName',Table.Properties.RowNames,'Units', 'Normalized', 'Position',[0, 0, 1, 1]);
