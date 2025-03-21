import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

//Classe principal
public class App extends JPanel {
    //Será necessário para guardar o ponto inicial e o ponto final
    private final List<Line> lines = new ArrayList<>();
    private Point startPoint = null;

    // Posição atual do cursor
    private Point cursorPoint = null;

    //Classe principal, representa a área onde os desenhos serão feitos
    public App() {
        setBackground(Color.WHITE);

        //Captura o movimento do mouse para desenhar um 'X' na posição atual do cursor
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (startPoint == null) {
                    startPoint = e.getPoint();
                } else {
                    lines.add(new Line(startPoint, e.getPoint()));
                    startPoint = null;

                    //Método para regravar os desenhos feitos quando o estado do painel muda
                    repaint();
                }
            }
        });

        //Efeito do X na ponto da seta
        addMouseMotionListener(new MouseMotionAdapter() {

            //Esse @Override é usado para definir um comportamento personalizado quando o mouse se move. Ele atualiza a posição do cursor e redesenha o componente
            //Atualização da posição do cursor
            @Override
            public void mouseMoved(MouseEvent e) {
                cursorPoint = e.getPoint();
                repaint();
            }
        });
    }

    @Override
    //Método para desenhar as linhas
    //O objeto Graphics é usado para desenhar os componentes gráficos
    protected void paintComponent(Graphics g) {

        //Sem essa chamada de superclasse, os desenhos anteriores podem não ser apagados corretamente, causando artefatos visuais
        super.paintComponent(g);

        g.setColor(Color.GREEN);

        for (Line line : lines) {
            //Usa o algoritmo Bresenham para desenhar a linha
            desenharLinha(g, line.start.x, line.start.y, line.end.x, line.end.y);
        }

        // Desenha um "X" vermelho na posição do cursor
        if (cursorPoint != null) {
            g.setColor(Color.RED);
            int size = 5;
            g.drawLine(cursorPoint.x - size, cursorPoint.y - size, cursorPoint.x + size, cursorPoint.y + size);
            g.drawLine(cursorPoint.x - size, cursorPoint.y + size, cursorPoint.x + size, cursorPoint.y - size);
        }
    }

    // Implementação do algoritmo Bresenham para desenhar uma linha entre dois pontos
    private void desenharLinha(Graphics g, int x0, int y0, int x1, int y1) {
        //x0 e y0 para o ponto inicial
        //x1 e y1 para o ponto final

        //dx e dy -> diferença absoluta entre as coordenadas x ou y do ponto final e do ponto inicial

        //sx e sy -> direção do incremento ou decremento na coordenada x e y

        //err -> direção do incremento ou decremento na coordenada


        //Usadas para calcular o deslocamento necessário em cada eixo para desenhar a linha
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        int sx = 0;

        if (x0 < x1){
            //Vai crescer para a direita
            sx = 1;
        }else{
            //Vai crescer para a esquerda
            sx = -1;
        };

        int sy = 0;
        if (y0 < y1) {
            sy = 1;
        }else{
            sy = -1;
        };

        //O erro (err) é um valor que decide quando o ponto deve mudar de coordenada
        int err = dx - dy;

        while (true) {
            //Método fillRect desenha os pixels individualmente
            g.fillRect(x0, y0, 2, 2);

            //Sai do loop quando atinge o ponto final
            if (x0 == x1 && y0 == y1){
                break;
            };

            int e2 = 2 * err;

            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }

    private static class Line {
        Point start, end;
        Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        //Janela principal da aplicação
        JFrame frame = new JFrame("Algoritmo de Bresenham");
        App panel = new App();

        //Criação do painel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(panel, BorderLayout.CENTER);

        //Painel que contém os botões de controle
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);

        //Botão de limpar
        JButton clearButton = new JButton("Limpar");
        clearButton.addActionListener(e -> {
            panel.lines.clear();
            panel.repaint();
        });

        //Botão de fechar
        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(clearButton);
        buttonPanel.add(closeButton);

        frame.add(buttonPanel, BorderLayout.WEST);
        frame.setVisible(true);
    }
}
