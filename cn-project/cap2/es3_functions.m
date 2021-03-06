%
% Metodo di Newton Modificato
% rispetto al metodo di newton standard, e' stato aggiunto
% il parametro di imput m, che rappresenta il
% coefficiente del termine di correzione
%
function [radice, it, valf, valf1] = newton_m(f, f1, x0, m, tlx, itmax)
    fx = feval(f, x0);
    f1x = feval(f1, x0);
    radice = x0 - fx/f1x;

    valf = 1;
    valf1 = 1;
    it = 1;

    while (it < itmax) && (abs(radice-x0)>tlx)
        x0 = radice;
        fx = feval(f, x0);
        f1x = feval(f1, x0);
        radice = x0 - m*(fx/f1x);

        valf = valf + 1;
        valf1 = valf1 + 1;
        it = it + 1;
    end

    if abs(radice-x0) > tlx
        error('non converge')
    end
end

%
% Metodo di Accelerazione di Aitken
%
function [radice, it, valf, val1] = aitken(f, f1, x0, tolx, imx)
    fx = feval(f, x0);
    f1x = feval(f1, x0);
    radice = x0 - fx/f1x;

    valf = 1;
    val1 = 1;
    it = 1;

    while (abs(radice-x0) > tolx) && (it < imx)
        x0 = radice;
        fx = feval(f, x0);
        f1x = feval(f1, x0);
        x1 = x0 - fx/f1x;
        fx = feval(f, x1);
        f1x = feval(f1, x1);
        radice = x1 - fx/f1x;
        radice = (radice*x0 - x1^2)/(radice-2*x1+x0);

        valf = valf + 2;
        val1 = val1 + 2;
        it = it + 1;
    end
end
