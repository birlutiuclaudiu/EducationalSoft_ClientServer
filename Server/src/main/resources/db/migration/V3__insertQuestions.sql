INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (1, 'Un cerc de rază R=10 are aria egală cu:', '20π', '100π', '50π', '100π^2',
        'A circle of radius R = 10 has an area equal to:', '20π', '100π', '50π', '100π^2',
        'Ein Kreis mit Radius R = 10 hat eine Fläche von:','20π', '100π', '50π', '100π^2',
        'B', '');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (2, 'Un cerc de rază R=5 are lungimea egală cu:', '10', '20π', '10π', '25π',
        'A circle of radius R = 10 has a length equal to:', '10', '20π', '10π', '25π',
        'Ein Kreis mit Radius R = 10 hat eine Länge von:', '10', '20π', '10π', '25π', 'C', '');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (3, 'Dacă lungimea unui cerc este 2π, atunci raza cercului cu centrul în originea sistemului de coordonate este:', '2', '2π', '4', '1',
        'If the length of a circle is 2π, then the radius of the circle with center at the origin of the coordinate system is:', '2', '2π', '4', '1',
        'Wenn die Länge eines Kreises 2π ist, dann ist der Radius des Kreises mit Mittelpunkt im Ursprung des Koordinatensystems:','2', '2π', '4', '1',
        'D', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (4, 'Lungimea arcului unui cerc de raza 1 cu o deschidere de π radians este :', '2', 'π', '4', '4π',
        'The length of the arc of a circle of radius 1 with an opening of π radians is:', '2', 'π', '4', '4π',
        'Die Länge des Bogens eines Kreises mit Radius 1 mit einer Öffnung von π Bogenmaß ist:','2', 'π', '4', '4π',
        'B', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (5, 'Mediatoarea triunghiului:', 'este perpendiculară pe mijlocul unei laturi ', 'nu poate fi identică cu înălțimea unui triunghi', 'se referă la mediana triunghiului', 'e o curbă',
        'The mediator of the triangle:', 'is perpendicular to the middle of one side', 'it cannot be identical to the height of a triangle', 'refers to the median of the triangle', 'it is a curve',
        'Der Mediator des Dreiecks:','ist senkrecht zur Mitte einer Seite', 'sie kann nicht mit der Höhe eines Dreiecks identisch sein', 'bezieht sich auf den Median des Dreiecks', 'es ist eine Kurve',
        'A', '');


------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (6, 'Punctul de intersecție al mediatoarelor laturilor unui triunghi oarecare ABC se numește centrul cercului circumscris triunghiului ABC.', 'fals, e dat de intersecția medianelor', 'fals, e dat de intersecția bisectoarelor', 'adevărat', 'fals, e dat de intersecția înălțimilor',
        'The point of intersection of the mediators of the sides of a triangle ABC is called the center of the circle circumscribed by the triangle ABC.', 'false, is given by the intersection of the medians', 'false, it is given by the intersection of the bisectors', 'true', 'false, it is given by the intersection of the heights',
        'Der Schnittpunkt der Vermittler der Seiten eines Dreiecks ABC heißt Mittelpunkt des vom Dreieck ABC umschriebenen Kreises.','falsch, ergibt sich aus dem Schnittpunkt der Mediane', 'falsch, sie ergibt sich aus dem Schnittpunkt der Winkelhalbierenden', 'wahr', 'falsch, sie ergibt sich aus dem Schnittpunkt der Höhen',
        'C', '');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (7, 'Punctul de intersecție al mediatoarelor laturilor unui triunghi oarecare ABC se numește centrul cercului înscris triunghiului ABC.', 'fals, e dat de intersecția medianelor', 'fals, e dat de intersecția bisectoarelor', 'adevărat', 'fals, e dat de intersecția înălțimilor',
        'The point of intersection of the mediators of the sides of a triangle ABC is called the center of the circle circumscribed by the triangle ABC.', 'false, is given by the intersection of the medians', 'false, it is given by the intersection of bisectors', 'true', 'false, it is given by the intersection of the heights',
        'Der Schnittpunkt der Vermittler der Seiten eines Dreiecks ABC heißt Mittelpunkt des vom Dreieck ABC umschriebenen Kreises.' ,'falsch, ergibt sich aus dem Schnittpunkt der Mediane', 'falsch, sie ergibt sich aus dem Schnittpunkt der Winkelhalbierenden', 'wahr', 'falsch, sie ergibt sich aus dem Schnittpunkt der Höhen',
        'B', '');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (8, 'Punctul de intersecție al bisectoarelor unghiurilor unui triunghi oarecare ABC se numește centrul cercului înscris triunghiului ABC.', 'fals, e dat de intersecția medianelor', 'fals, e dat de intersecția mediatoarelor', 'adevărat', 'fals, e dat de intersecția înălțimilor',
        'The point of intersection of the mediators of the sides of a triangle ABC is called the center of the circle circumscribed by the triangle ABC.', 'false, is given by the intersection of the medians', 'false, it is given by the intersection of mediators', 'true', 'false, it is given by the intersection of the heights',
        'Der Schnittpunkt der Vermittler der Seiten eines Dreiecks ABC heißt Mittelpunkt des vom Dreieck ABC umschriebenen Kreises.','falsch, ergibt sich aus dem Schnittpunkt der Mediane', 'falsch, sie ergibt sich aus der Schnittmenge der Mediatoren', 'wahr', 'falsch, sie ergibt sich aus dem Schnittpunkt der Höhen',
        'C', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (9, 'Numim antiparalelă a laturii BC a triunghiului ABC, o dreaptă paralelă cu tangenta în vârful A la cercul circumscris triunghiului ABC.',
                'fals, e paralela cu tangenta la cercul inscris', 'fals, e paralela cu tangenta la cercul lui Brocard ', 'fals, e paralela cu tangenta la cercul lui Tucker', 'adevărat',
        'We call antiparallel the side BC of the triangle ABC, a line parallel to the tangent at the vertex A to the circle circumscribed to the triangle ABC.',
                'false, is parallel to the tangent to the inscribed circle', 'false, parallel to the tangent to Brocard''s circle', 'false, is parallel to the tangent to Tucker s circle', 'true',
        'Wir nennen die Seite BC des Dreiecks ABC antiparallel, eine Linie, die parallel zur Tangente an der Spitze A an dem Kreis liegt, der dem Dreieck ABC umschrieben ist.',
                'falsch, ist parallel zur Tangente an den einbeschriebenen Kreis', 'falsch, parallel zur Tangente an Brocards Kreis', 'falsch, ist parallel zur Tangente an Tuckers Kreis', 'wahr',
        'D', 'icons/questions/9_antiparalela.png');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (10, 'Poligonul regulat este un poligon simplu ce are:', 'toate unghiurile egale, dar nu si laturile', 'toate unghiurile si laturile egale', 'toate laturile egale, dar nu si unghiurile', 'doar 2 laturi',
        'The regular polygon is a simple polygon that has:', 'all angles equal, but not the sides', 'all angles and sides equal', 'all sides equal, but not angles', 'only 2 sides',
        'Das regelmäßige Vieleck ist ein einfaches Vieleck mit:','alle Winkel gleich, aber nicht die Seiten', 'alle Winkel und Seiten gleich', 'alle Seiten gleich, aber keine Winkel', 'nur 2 seiten',
        'B', '');


------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (11, 'În figura alăturată e ilustrat: ', 'cercul înscris triunghiului', 'cercul circumscris triunghiului', 'cercul lui Brocard', 'cercul lui Tucker',
        'The figure below shows:', 'the circle inscribed in the triangle', 'the circle around the triangle', 'Brocard''s circle', 'Tucker''s circle',
        'Die folgende Abbildung zeigt:','der in das Dreieck eingeschriebene Kreis', 'der Kreis um das Dreieck', 'Brocards Kreis', 'Tuckers Kreis',
        'A', 'icons/questions/11_inscris.jpg');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (12, 'Trei cercuri C1,C2,C3 tangente interior la cercul circumscris triunghiului ABC în vârfurile A,B,C și tangente între ele două câte două se numesc cercurile lui Lucas: ',
                'fals, sunt cercurile lui Neuberg', 'fals, sunt cercurile lui Adams', 'fals, sunt cercurile lui Tucker', 'true',
        'Three circles C1, C2, C3 tangent to the inner circle of the triangle ABC at the vertices A, B, C and tangent to each other are called Lucas''s circles:',
             'false, it''s Neuberg''s circles', ' false, it''s Adams'' circles',  'false, it s Tucker''s circles',  ' true ',
        'Drei Kreise C1, C2, C3, die den Innenkreis des Dreiecks ABC an den Ecken A, B, C tangieren und einander berühren, heißen Lucas-Kreise:',
              'falsch, es sind Neubergs Kreise', 'falsch, es sind Adams'' Kreise', 'falsch, es sind Tuckers Kreise', 'wahr',
        'D', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (13, 'Trei cercuri C1,C2,C3 tangente interior la cercul înscris triunghiului ABC în vârfurile A,B,C și tangente între ele două câte două se numesc cercurile lui Lucas: ',
            'fals, sunt cercurile lui Neuberg', 'fals, sunt cercurile lui Adams', 'fals, sunt tangente cercului circumscris triunghiului ABC', 'true',
        'Three circles C1, C2, C3 tangent to the inner circle of the triangle ABC at the vertices A, B, C and tangent to each other are called Lucas''s circles:',
            'false, it''s Neuberg''s circles', ' false, it''s Adams'' circles',  'false, are tangent to the circle around the triangle ABC',  ' true ',
        'Drei Kreise C1, C2, C3, die den Innenkreis des Dreiecks ABC an den Ecken A, B, C tangieren und einander berühren, heißen Lucas-Kreise:',
            'falsch, es sind Neubergs Kreise', 'falsch, es sind Adams'' Kreise', 'falsch, tangieren den Kreis um das Dreieck ABC', 'wahr',
        'C', '');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (14, 'Despre unghiul lui Brocard (w) într-un triunghi cu unghiurile a, b și c se cunoaște: ',
            'cot w = cot a + cot b + cot c', 'cos w = cos a + cos b + cos c', 'cos w = cot a + cot b + cot c', 'sin w = sin a + sin b + sin c',
        'The angle of Brocard (w) in a triangle with angles a, b and c is known:',
            'cot w = cot a + cot b + cot c', 'cos w = cos a + cos b + cos c', 'cos w = cot a + cot b + cot c', 'sin w = sin a + sin b + sin c',
        'Der Winkel von Brocard (w) in einem Dreieck mit den Winkeln a, b und c ist bekannt:',
            'cot w = cot a + cot b + cot c', 'cos w = cos a + cos b + cos c', 'cos w = cot a + cot b + cot c', 'sin w = sin a + sin b + sin c',
        'A', '');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (15, 'Numim simediana a unui triunghi:  ',
            'izogonala mediatoarei', 'izogonala medianei', 'mijlocul medianei', 'modulul medianei',
        'We call the simedian of a triangle:',
            'isogonal mediator', 'isogonal to the median', 'middle median', 'the modulus of the median',
        'Wir nennen den Simedian eines Dreiecks:',
            'isogonaler Vermittler', 'isogonal zum Median', 'mittlerer Median', 'der Modul des Medians',
        'B', '');

------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (16, 'Suma măsurilor unghiurilor unui triunghi:  ',
             '90', '360', '60', '180',
        'The sum of the measures of the angles of a triangle:',
             '90', '360', '60', '180',
        'Die Summe der Winkelmaße eines Dreiecks:',
             '90', '360', '60', '180',
        'D', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (17, 'Suma masurilor unghiurilor unui poligon convex cu n laturi este:   ',
             '(n-1)*180', '360', '(n-2)*180', '180',
        'The sum of the measures of the angles of a convex polygon with n sides is:',
             '(n-1)*180', '360', '(n-2)*180', '180',
        'Die Summe der Winkelmaße eines konvexen Polygons mit n Seiten ist:',
             '(n-1)*180', '360', '(n-2)*180', '180',
        'C', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (18, 'Suma masurilor unghiurilor unui poligon convex cu n laturi este:   ',
        '(n-1)*180', '360', '(n-2)*180', '180',
        'The sum of the measures of the angles of a convex polygon with n sides is:',
        '(n-1)*180', '360', '(n-2)*180', '180',
        'Die Summe der Winkelmaße eines konvexen Polygons mit n Seiten ist:',
        '(n-1)*180', '360', '(n-2)*180', '180',
        'C', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (19, 'Suma masurilor unghiurilor unui poligon convex cu 7 laturi este:  ',
            '420', '360', '1800', '900',
        'The sum of the measures of the angles of a convex polygon with 7 sides is:',
            '420', '360', '1800', '900',
        'Die Summe der Winkelmaße eines konvexen Polygons mit 7 Seiten ist:',
             '420', '360', '1800', '900',
        'D', '');


------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (20, 'Lungimea ipotenuzei unui triunghi dreptunghic este de 15 cm. Lungimea unei catete este de 9 cm. Găsiți lungimea celeilalte catete.:   ',
                '6', '12', '17', '144',
        'The length of the hypotenuse of a right triangle is 15 cm. The length of one leg is 9 cm. Find the length of the other leg.',
                '6', '12', '17', '144',
        'Die Länge der Hypotenuse eines rechtwinkligen Dreiecks beträgt 15 cm. Die Länge eines Beins beträgt 9 cm. Finde die Länge des anderen Beins.:',
                '6', '12', '17', '144',
        'B', 'icons/questions/20_triangle.jpg');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (21, 'Numărul de diagonale a unui poligon convex cu n laturi este:   ',
            'n(n-3)/2', 'n(n-1)(n-2)', 'n(n-3)', 'n',
        'The number of diagonals of a n-sided convex polygon is:',
            'n(n-3)/2', 'n(n-1)(n-2)', 'n(n-3)', 'n',
        'Die Anzahl der Diagonalen eines n-seitigen konvexen Polygons ist:',
            'n(n-3)/2', 'n(n-1)(n-2)', 'n(n-3)', 'n',
        'A', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (22, 'Numărul de diagonale a unui poligon convex cu 100 laturi este:   ',
        '4850', '5000', '101', '5',
        'The number of diagonals of a 100-sided convex polygon is:',
        '4850', '5000', '101', '5',
        'Die Anzahl der Diagonalen eines 100-seitigen konvexen Polygons ist:',
        '4850', '5000', '101', '5',
        'A', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (23, 'Numărul de diagonale a unui poligon convex cu 3 laturi este:   ',
        '0', '20', '4', '5',
        'The number of diagonals of a 100-sided convex polygon is:',
        '0', '20', '4', '5',
        'Die Anzahl der Diagonalen eines 100-seitigen konvexen Polygons ist:',
        '0', '20', '4', '5',
        'A', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (24, 'Care este suma unghiurilor exterioare ale unui 34-gon?  ',
             '180', '5760', '360', '90',
        'What is the sum of the exterior angles of a 34-gon?',
            '180', '5760', '360', '90',
        'Wie groß ist die Summe der Außenwinkel eines 34-Ecks?',
            '180', '5760', '360', '90',
        'C', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (25, 'Care este măsura fiecărui unghi exterior al unui heptagon obișnuit?  ',
        '51.43°', '90°', '72°', '108°',
        'What is the measure of each exterior angle of a regular heptagon?',
        '51.43°', '90°', '72°', '108°',
        'Wie groß ist jeder Außenwinkel eines regelmäßigen Siebenecks?',
        '51.43°', '90°', '72°', '108°',
        'A', '');


------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (26, 'Care este măsura fiecărui unghi interior al unui pentagon obișnuit?  ',
             '540°', '90°', '72°', '108°',
        'What''s the measure of each interior angle of a regular pentagon?',
             '540°', '90°', '72°', '108°',
        'Was ist das Maß für jeden Innenwinkel eines regelmäßigen Fünfecks?',
            '540°', '90°', '72°', '108°',
        'D', '');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (27, 'Medianele există în care dintre următoarele forme/forme?',
             'Paralelogram', 'Trapez', 'Romb', 'toate variantele',
        'Medians exist in which of the following shape/shapes?',
            'Parallelogram', 'Trapezoid', 'Rhombus', 'all of above',
        'In welcher der folgenden Formen gibt es Mediane?',
             'Parallelogramm', 'Trapez', 'Rhombus', 'alles von oben',
        'B', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (28, 'Care este ecuația pentru aria unui romb? h -înăltimea, b-lungimea unei laturi, D1, D2 - diagonale',
             'A = b*h', 'A = 1/2 b * h', 'A = 1/2 D1 * D2', 'A = 1/2 * h * (b1 + b2)',
        'What is the equation for the area of a rhombus? h -height, b-length of one side, D1, D2 - diagonal',
             'A = b*h', 'A = 1/2 b * h', 'A = 1/2 D1 * D2', 'A = 1/2 * h * (b1 + b2)',
        'Wie lautet die Flächengleichung einer Raute? h -Höhe, b-Länge einer Seite, D1, D2 - Diagonale',
            'A = b*h', 'A = 1/2 b * h', 'A = 1/2 D1 * D2', 'A = 1/2 * h * (b1 + b2)',
        'C', '');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (29, 'Arcurile egale subtind unghiuri egale în centrul cercului, este o regulă asociată cu geometria cercului. Ce altă parte geometrică a unui cerc poate fi asociată cu această regulă?',
        'Secanta', 'Raza', 'Tangenta', 'Coarda',
        'Equal arcs subtend equal angles at the centre of the circle, is a rule associated with circle geometry. Which other geometric part of a circle can be associated with this rule?',
        'Secant', 'Radius', 'Tangent', 'Chord',
        'Gleiche Bögen schließen gleiche Winkel in der Mitte des Kreises ein, ist eine Regel, die mit der Kreisgeometrie verbunden ist. Welcher andere geometrische Teil eines Kreises kann dieser Regel zugeordnet werden?',
        'Sekante', 'Radius', 'Tangente', 'Akkord',
        'D', '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (30, 'Tangenta la un cerc este perpendiculară pe care altă parte a cercului în punctul de contact?',
        'Secanta', 'Raza', 'Tangenta', 'Coarda',
        'The tangent to a circle is perpendicular to which other part of the circle at the point of contact?',
        'Secant', 'Radius', 'Tangent', 'Chord',
        'Die Tangente an einen Kreis steht am Berührungspunkt senkrecht auf welchem anderen Teil des Kreises?',
        'Sekante', 'Radius', 'Tangente', 'Akkord',
        'B', '');
------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (31, 'Dacă NO = 4, care este lungimea razei cercului M?',
            '2.3094', '1.2801', '3.028', '1.0341',
        'If NO = 4, what''s the length of the radius of circle M?',
            '2.3094', '1.2801', '3.028', '1.0341',
        'Wenn NO = 4, wie lang ist der Radius des Kreises M?',
            '2.3094', '1.2801', '3.028', '1.0341',
        'A',  'icons/questions/31_circleTangent.png');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (32, 'Dacă NO = 4, care este aria cercului M?',
        '7.218421π', '5.308416π', '4π', '4.201313π',
        'If NO = 4, what is the area of the circle M?',
        '7.218421π', '5.308416π', '4π', '4.201313π',
        'Wenn NO = 4, was ist die Fläche des Kreises M?',
        '7.218421π', '5.308416π', '4π', '4.201313π',
        'B',  'icons/questions/31_circleTangent.png');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (33, 'Dacă NO = 4, care este lungimea cercului M?',
        '2π*2.3094', 'π*1.2801', '2π*3.028', '2*π1.0341',
        'If NO = 4, what is the length of the circle M?',
        '2π*2.3094', 'π*1.2801', '2π*3.028', '2*π1.0341',
        'Wenn NO = 4, wie lang ist der Kreis M?',
        '2π*2.3094', 'π*1.2801', '2π*3.028', '2*π1.0341',
        'A',  'icons/questions/31_circleTangent.png');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (34, 'Care este punctul de concurență al medianelor?',
        'Centrul cercului inscris', 'Ortocentru', 'Centru de greutate', 'Centrul cercului circumscris',
        'What is the point of concurrency of the medians?',
        'Incenter', 'Orthocenter', 'Centroid', 'Circumcenter',
        'Was ist der Punkt der Gleichzeitigkeit der Mediane?',
        'Zentrum des einbeschriebenen Kreises', 'Orthozentrum', 'Schwerpunkt', 'Zentrum des umschriebenen Kreises',
        'C',  '');
INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (35, 'Selectează varianta corectă',
        'X = 5, and y = 5*sqrt(3)', 'X = 5, and y = 5*sqrt(2)', 'X = 5*sqrt(3), and y = 5', 'X = 5*sqrt(2), and y = 5*sqrt(2)',
        'Select the correct option',
        'X = 5, and y = 5*sqrt(3)', 'X = 5, and y = 5*sqrt(2)', 'X = 5*sqrt(3), and y = 5', 'X = 5*sqrt(2), and y = 5*sqrt(2)',
        'Wählen Sie die richtige Option aus',
        'X = 5, and y = 5*sqrt(3)', 'X = 5, and y = 5*sqrt(2)', 'X = 5*sqrt(3), and y = 5', 'X = 5*sqrt(2), and y = 5*sqrt(2)',
        'A',  'icons/questions/35_triangle.jpg');

------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (36, 'Selectează varianta corectă',
        'X = 5, and y = 5*sqrt(3)', 'X = 5*sqrt(3), and y = 10*sqrt(3)', 'X = 5*sqrt(3), and y = 5', 'X = 5*sqrt(2), and y = 5*sqrt(2)',
        'Select the correct option',
        'X = 5, and y = 5*sqrt(3)', 'X = 5*sqrt(3), and y = 10*sqrt(3)', 'X = 5*sqrt(3), and y = 5', 'X = 5*sqrt(2), and y = 5*sqrt(2)',
        'Wählen Sie die richtige Option aus',
        'X = 5, and y = 5*sqrt(3)', 'X = 5*sqrt(3), and y = 10*sqrt(3)', 'X = 5*sqrt(3), and y = 5', 'X = 5*sqrt(2), and y = 5*sqrt(2)',
        'B',  'icons/questions/36_triangle.jpg');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (37, 'Selectează varianta corectă',
        'X = 5, and y = 5*sqrt(3)', 'X = 5*sqrt(3), and y = 10*sqrt(3)', 'X=140, and y=70*sqrt(3)', 'X = 5*sqrt(2), and y = 5*sqrt(2)',
        'Select the correct option',
        'X = 5, and y = 5*sqrt(3)', 'X = 5*sqrt(3), and y = 10*sqrt(3)', 'X=140, and y=70*sqrt(3)', 'X = 5*sqrt(2), and y = 5*sqrt(2)',
        'Wählen Sie die richtige Option aus',
        'X = 5, and y = 5*sqrt(3)', 'X = 5*sqrt(3), and y = 10*sqrt(3)', 'X=140, and y=70*sqrt(3)', 'X = 5*sqrt(2), and y = 5*sqrt(2)',
        'C',  'icons/questions/37_triangle.jpg');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (38, 'Dacă o coardă de 12 cm lungime este trasă la 8 km de centrul cercului, acum raza cercului este?',
        '10', '6', '5', '2.4',
        'If 12 cm long chord is drawn at 8 km far from the center of the circle, now the radius of the circle is?',
        '10', '6', '5', '2.4',
        'Wenn eine 12 cm lange Sehne in 8 km Entfernung vom Mittelpunkt des Kreises gezeichnet wird, ist der Radius des Kreises jetzt?',
        '10', '6', '5', '2.4',
        'A',  '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (39, 'Care este aria unui triunghi cu baza de 10 cm și înălțimea de 25 cm?',
            'A=35 cm^2', 'A=65.5 cm^2 ', 'A=125 cm^2', 'A=250 cm^2',
        'What is the area of a triangle with base 10 cm and height 25 cm?',
            'A=35 cm^2', 'A=65.5 cm^2 ', 'A=125 cm^2', 'A=250 cm^2',
        'Wie groß ist der Flächeninhalt eines Dreiecks mit einer Grundfläche von 10 cm und einer Höhe von 25 cm?',
            'A=35 cm^2', 'A=65.5 cm^2 ', 'A=125 cm^2', 'A=250 cm^2',
        'C',  '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (40, 'Care este aria unui paralelogram cu baza de 30 cm și înălțimea de 25 cm?',
        'A=25 cm^2', 'A=65.5 cm^2 ', 'A=187.5 cm^2', 'A=750 cm^2',
        'What is the area of a parallelogram with base 30 cm and height 25 cm?',
        'A=25 cm^2', 'A=65.5 cm^2 ', 'A=187.5 cm^2', 'A=750 cm^2',
        'Welchen Flächeninhalt hat ein Parallelogramm mit einer Grundfläche von 30 cm und einer Höhe von 25 cm?',
        'A=25 cm^2', 'A=65.5 cm^2 ', 'A=187.5 cm^2', 'A=750 cm^2',
        'D',  '');

------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (41, 'Aflați ecuația cercului cu centrul (-1, 2) și raza = 2 unități.',
            'Option 1', 'Option 1 and Option 3', 'Option 3', 'Option 2 and Option 3',
        'Find the equation of the circle with centre (-1, 2) and radius = 2 units.',
            'Option 1', 'Option 1 and Option 3', 'Option 3', 'Option 2 and Option 3',
        'Finden Sie die Gleichung des Kreises mit Mittelpunkt (-1, 2) und Radius = 2 Einheiten.',
            'Option 1', 'Option 1 and Option 3', 'Option 3', 'Option 2 and Option 3',
        'B',  'icons/questions/41_circleEquation1.jpg');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (42, 'Având în vedere că A = ( -2, 0) și B = (4, 8) și segmentul de dreaptă AB este diametrul cercului. Găsiți ecuația cercului.',
            'Option 1 and Option 4', 'Option 2 and Option 3', 'Option 1 and Option 3', 'Option 2 and Option 4',
        'Given that A = ( -2, 0) and B = (4, 8) and the line segment AB is the diameter of the circle. Find the equation of the circle.',
             'Option 1 and Option 4', 'Option 2 and Option 3', 'Option 1 and Option 3', 'Option 2 and Option 4',
        'Angenommen, A = (-2, 0) und B = (4, 8) und das Liniensegment AB ist der Durchmesser des Kreises. Finde die Kreisgleichung.',
            'Option 1 and Option 4', 'Option 2 and Option 3', 'Option 1 and Option 3', 'Option 2 and Option 4',
        'C',  'icons/questions/42_circleEquation2.jpg');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (43, 'Centrul cercului dat de ecuatia x^2 + y^2 - 4x -8y -5 =0',
            'C(2, 6)', 'C(2, -4)', 'C(-2, 4)', 'C(2, 4)',
        'The center of the circle given by the equation  x^2 + y^2 - 4x -8y -5 = 0.',
            'C(2, 6)', 'C(2, -4)', 'C(-2, 4)', 'C(2, 4)',
        'Der Mittelpunkt des Kreises, gegeben durch die Gleichung  x^2 + y^2 - 4x -8y -5 = 0.',
            'C(2, 6)', 'C(2, -4)', 'C(-2, 4)', 'C(2, 4)',
        'D',  '');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (44, 'Raza cercului dat de ecuatia  x^2 + y^2 - 4x + 6y -23 =0',
             'R=4', 'R=5', 'R=6', 'R=6',
        'The radius of the circle given by the equation  x^2 + y^2 - 4x + 6y -23 =0',
            'R=4', 'R=5', 'R=6', 'R=6',
        'Der Radius des durch die Gleichung gegebenen Kreises  x^2 + y^2 - 4x + 6y -23 =0',
            'R=4', 'R=5', 'R=6', 'R=6',
        'C',  '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (45, 'Care este x în dreptunghiul de mai jos?',
            '22°', '158°', '68°', '136°',
        'What is x in the rectangle below?',
            '22°', '158°', '68°', '136°',
        'Was ist x im Rechteck unten?',
            '22°', '158°', '68°', '136°',
        'D',  'icons/questions/45_rectangle.jpg');


------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (46, 'AB și AC sunt coarde ale unui cerc cu tangentă la A. Unghiul dintre tangentă și coarda AC este egal cu ce alt unghi?',
           'Unghi BAC', 'Unghi exterior la B', 'Unghi ACB', 'Unghi ABC',
        'AB and AC are chords of a circle with a tangent at A. The angle between the tangent and the chord AC is equal to which other angle?',
            'Angle BAC', 'Exterior angle at B', 'Angle ACB', 'Angle ABC',
        'AB und AC sind Kreissehnen mit einer Tangente bei A. Der Winkel zwischen der Tangente und der Sehne AC ist gleich welchem anderen Winkel?',
            'BAC-Winkel', 'B-Außenwinkel', 'ACB-Winkel', 'ABC-Winkel',
        'D',  '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (47, 'O tangentă la cerc în punctul A are 7 cm lungime și se întâlnește în punctul extern C. A doua tangentă la cerc în punctul B se întâlnește și în punctul extern C. BC=?',
        '14 cm', '3.5 cm', '7 cm', '10.5 cm',
        'One tangent to the circle at point A is 7cm long and meets at the external point C. The second tangent to the circle at point B also meets at the external point C. BC=?',
        '14 cm', '3.5 cm', '7 cm', '10.5 cm',
        'Eine Tangente an den Kreis an Punkt A ist 7 cm lang und trifft auf den äußeren Punkt C. Die zweite Tangente an den Kreis an Punkt B trifft ebenfalls auf den äußeren Punkt C. BC=?',
        '14 cm', '3.5 cm', '7 cm', '10.5 cm',
        'C',  '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (48, 'ABCD este un patrulater ciclic care se află în interiorul unui cerc. Dacă unghiul ABC este egal cu 56, atunci care este valoarea unghiului ADC?',
        '146', '56', '124', '34',
        'ABCD is a cyclic quadrilateral that lies inside a circle. If angle ABC is equal to 56, then what is the value of angle ADC?',
        '146', '56', '124', '34',
        'ABCD ist ein zyklisches Viereck, das innerhalb eines Kreises liegt. Wenn der Winkel ABC gleich 56 ist, welchen Wert hat dann der Winkel ADC?',
        '146', '56', '124', '34',
        'C',  '');

INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (49, 'AB și CD sunt coarde ale unui cerc care se intersectează în punctul E. Dacă AB=12,3cm, EB=2,7cm și DE=10,6cm, atunci care este valoarea EC? (corect la 1 dec pl)',
        '1.9', '3.4', '3', '2.4',
        'AB and CD are chords of a circle that intersect at point E. If AB=12.3cm, EB=2.7cm and DE=10.6cm, then what is the value of EC? (correct to 1 dec pl)',
        '1.9', '3.4', '3', '2.4',
        'AB und CD sind Kreissehnen, die sich im Punkt E schneiden. Wenn AB = 12,3 cm, EB = 2,7 cm und DE = 10,6 cm, was ist dann der Wert von EC? (korrigieren auf 1 dez pl)',
        '1.9', '3.4', '3', '2.4',
        'D',  '');


INSERT INTO public.questions(
    question_id,  romanian_body, romanian_answer_a, romanian_answer_b, romanian_answer_c, romanian_answer_d,  english_body, english_answer_a, english_answer_b, english_answer_c, english_answer_d, german_body, german_answer_a, german_answer_b, german_answer_c, german_answer_d, correct_answer,figure_url)
VALUES (50, 'Dacă o coardă de 12 cm lungime este trasă la 8 km de centrul cercului, acum raza cercului este?',
            '10', '6', '5', '2.4',
        'If 12 cm long chord is drawn at 8 km far from the center of the circle, now the radius of the circle is?',
            '10', '6', '5', '2.4',
        'Wenn eine 12 cm lange Sehne in 8 km Entfernung vom Mittelpunkt des Kreises gezeichnet wird, ist der Radius des Kreises jetzt?',
            '10', '6', '5', '2.4',
        'A',  '');











