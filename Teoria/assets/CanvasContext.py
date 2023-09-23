from IPython.display import display, HTML, Javascript

class CanvasContext:

    js_src = ""

    PROPERTIES = {
        "lineWidth": {"type": "number", "default": 1.0},
        "lineCap": {"type": "string", "default": "butt"},  # butt, round, square
        "lineJoin": {"type": "string", "default": "miter"},  # miter, round, bevel
        "miterLimit": {"type": "number", "default": 10.0},
        "lineDashOffset": {"type": "number", "default": 0.0},
        "font": {"type": "string", "default": "10px sans-serif"},
        "textAlign": {"type": "string", "default": "start"},  # start, end, left, right, center
        "textBaseLine": {"type": "string", "default": "alphabetic"},  # alphabetic, top, hanging, middle, ideographic, bottom
        "direction": {"type": "string", "default": "inherit"},  # ltr, rtl, inherit
        "letterSpacing": {"type": "number", "default": 0},
        "fontKerning": {"type": "string", "default": "auto"},  # auto, normal, none
        "wordSpacing": {"type": "number", "default": 0},
        "fillStyle": {"type": "string", "default": "blue"},
        "strokeStyle": {"type": "string", "default": "black"},
        "shadowBlur": {"type": "number", "default": 0},
        "shadowColor": {"type": "string", "default": "transparent black"},
        "shadowOffsetX": {"type": "number", "default": 0},
        "shadowOffsetY": {"type": "number", "default": 0},
        "globalAlpha": {"type": "number", "default": 1.0},
        "isSmoothingEnabled": {"type": "boolean", "default": True},
        "globalCompositeOperation": {"type": "string", "default": "source-over"},  # Hi ha molts valors possibles, source-over és el predeterminat
        "imageSmoothingQuality": {"type": "string", "default": "low"},  # low, medium, high
        "canvas": {"type": "object", "default": None},  # Això pot necessitar una gestió especial segons com es vulgui utilitzar
        "filter": {"type": "string", "default": "none"}  # none, blur(), brightness(), etc.
    }

    def __init__(self, canvas_id, ample=400, alt=400):
        
        self.canvas_id = canvas_id

        # Inicialitzem amb el valor per defecte
        for prop, meta in self.PROPERTIES.items():
            setattr(self, f"_{prop}", meta["default"])  
        
        # Iniciar el canvas
        display(HTML(f"""<canvas id="{self.canvas_id}" width="{ample}" height="{alt}" style="border:1px solid black;"></canvas>"""))
        
        # Inicialitzem el contexte
        js_code = f"""
        var canvas = document.getElementById('{self.canvas_id}');
        var ctx = canvas.getContext('2d');
        """
        CanvasContext.js_src += js_code

    def display(self):
        display(Javascript(CanvasContext.js_src))

    def _set_property(self, prop_name, value):
        meta = self.PROPERTIES[prop_name]
        if meta["type"] == "string":
            value = f"'{value}'"
        elif meta["type"] == "number":
            value = str(value)  # Convertim el número a string per a la interpolació
        # Si es necessiten altres conversions de tipus, es poden afegir aquí

        setattr(self, f"_{prop_name}", value)
        js_code = f"""
        ctx.{prop_name} = {value};
        """
        CanvasContext.js_src += js_code

    def _get_property(self, prop_name):
        return getattr(self, f"_{prop_name}")

    def measureText(self, text):
        # TODO
        return float(0.0)

    def isPointInPath(self, x, y):
        # TODO
        return bool(True)

    def isPointInStroke(self, x, y):
        # TODO
        return bool(True)

    def getTransform(self):
        # TODO
        return []

    def getLineDash(self):
        # TODO
        return []

    def save(self):
        js_code = f"""
        ctx.save();
        """
        CanvasContext.js_src += js_code

    def restore(self):
        js_code = f"""
        ctx.restore();
        """
        CanvasContext.js_src += js_code

    def rectangle(self, x, y, ample, alt):
        js_code = f"""
        ctx.rect({x}, {y}, {ample}, {alt});
        """
        CanvasContext.js_src += js_code

    def fillRect(self, x, y, ample, alt):
        js_code = f"""
        ctx.fillRect({x}, {y}, {ample}, {alt});
        """
        CanvasContext.js_src += js_code

    def clearRect(self, x, y, ample, alt):
        js_code = f"""
        ctx.clearRect({x}, {y}, {ample}, {alt});
        """
        CanvasContext.js_src += js_code

    def strokeRect(self, x, y, ample, alt):
        js_code = f"""
        ctx.strokeRect({x}, {y}, {ample}, {alt});
        """
        CanvasContext.js_src += js_code

    def fillText(self, text, x, y, maxAmple=None):
        maxAmpleStr = f", {maxAmple}" if maxAmple else ""
        js_code = f"""
        ctx.fillText('{text}', {x}, {y}{maxAmpleStr});
        """
        CanvasContext.js_src += js_code

    def strokeText(self, text, x, y, maxAmple=None):
        maxAmpleStr = f", {maxAmple}" if maxAmple else ""
        js_code = f"""
        ctx.strokeText('{text}', {x}, {y}{maxAmpleStr});
        """
        CanvasContext.js_src += js_code

    def beginPath(self):
        js_code = f"""
        ctx.beginPath();
        """
        CanvasContext.js_src += js_code

    def closePath(self):
        js_code = f"""
        ctx.closePath();
        """
        CanvasContext.js_src += js_code

    def moveTo(self, x, y):
        js_code = f"""
        ctx.moveTo({x}, {y});
        """
        CanvasContext.js_src += js_code

    def lineTo(self, x, y):
        js_code = f"""
        ctx.lineTo({x}, {y});
        """
        CanvasContext.js_src += js_code

    def bezierCurveTo(self, cp1x, cp1y, cp2x, cp2y, x, y):
        js_code = f"""
        ctx.bezierCurveTo({cp1x}, {cp1y}, {cp2x}, {cp2y}, {x}, {y});
        """
        CanvasContext.js_src += js_code

    def quadraticCurveTo(self, cpx, cpy, x, y):
        js_code = f"""
        ctx.quadraticCurveTo({cpx}, {cpy}, {x}, {y});
        """
        CanvasContext.js_src += js_code

    def arc(self, x, y, radius, startAngle, endAngle, anticlockwise=False):
        js_code = f"""
        ctx.arc({x}, {y}, {radius}, {startAngle}, {endAngle}, {str(anticlockwise).lower()});
        """
        CanvasContext.js_src += js_code

    def arcTo(self, x1, y1, x2, y2, radius):
        js_code = f"""
        ctx.arcTo({x1}, {y1}, {x2}, {y2}, {radius});
        """
        CanvasContext.js_src += js_code

    def ellipse(self, x, y, radiusX, radiusY, rotation, startAngle, endAngle, anticlockwise=False):
        js_code = f"""
        ctx.ellipse({x}, {y}, {radiusX}, {radiusY}, {rotation}, {startAngle}, {endAngle}, {str(anticlockwise).lower()});
        """
        CanvasContext.js_src += js_code

    def roundRect(self, x, y, width, height, radius):
        # Implementació de rectangle amb cantons arrodonits amb un radi determinat
        js_code = f"""
        ctx.roundRect({x}, {y} , {width}, {height}, {radius});
        """
        CanvasContext.js_src += js_code

    def fill(self):
        js_code = f"""
        ctx.fill();
        """
        CanvasContext.js_src += js_code

    def stroke(self):
        js_code = f"""
        ctx.stroke();
        """
        CanvasContext.js_src += js_code

    def clip(self):
        js_code = f"""
        ctx.clip();
        """
        CanvasContext.js_src += js_code

    def rotate(self, angle):
        js_code = f"""
        ctx.rotate({angle});
        """
        CanvasContext.js_src += js_code

    def scale(self, scaleX, scaleY):
        js_code = f"""
        ctx.scale({scaleX}, {scaleY});
        """
        CanvasContext.js_src += js_code

    def translate(self, x, y):
        js_code = f"""
        ctx.translate({x}, {y});
        """
        CanvasContext.js_src += js_code

    def transform(self, a, b, c, d, e, f):
        js_code = f"""
        ctx.transform({a}, {b}, {c}, {d}, {e}, {f});
        """
        CanvasContext.js_src += js_code

    def setTransform(self, a, b, c, d, e, f):
        js_code = f"""
        ctx.setTransform({a}, {b}, {c}, {d}, {e}, {f});
        """
        CanvasContext.js_src += js_code

    def resetTransform(self):
        js_code = f"""
        ctx.resetTransform();
        """
        CanvasContext.js_src += js_code

    def drawImage(self, source, sx, sy, sWidth, sHeight, dx, dy, dWidth, dHeight):
        js_code = f"""
        var img = new Image();
        img.src = '{source}';
        img.onload = function() {{
            ctx.drawImage(img, {sx}, {sy}, {sWidth}, {sHeight}, {dx}, {dy}, {dWidth}, {dHeight});
        }};
        """
        CanvasContext.js_src += js_code

    def putImageData(self, imageData, dx, dy):
        # Aquí, imageData hauria de ser una cadena que representi les dades de la imatge
        js_code = f"""
        ctx.putImageData({imageData}, {dx}, {dy});
        """
        CanvasContext.js_src += js_code

    def setLineDash(self, segments):
        # Aquí, `segments` hauria de ser una llista o array de números
        js_code = f"""
        ctx.setLineDash([{",".join(map(str, segments))}]);
        """
        CanvasContext.js_src += js_code

    def drawWhiteBackground(self):
        js_code = f"""
        ctx.save();
        ctx.fillStyle = "white";
        ctx.fillRect(0, 0, ctx.canvas.width, ctx.canvas.height);
        ctx.restore();
        """
        CanvasContext.js_src += js_code

    def drawGridBackground(self):
        self.drawWhiteBackground()
        js_code = f"""
        ctx.save();
        for (let x = 0; x <= ctx.canvas.width; x += 25) {{
            ctx.strokeStyle = (x % 50 === 0) ? "#888888" : "#cccccc";
            ctx.beginPath();
            ctx.moveTo(x, 0);
            ctx.lineTo(x, ctx.canvas.height);
            ctx.stroke();
            
            if (x % 50 === 0 && x !== 0) {{
                ctx.fillStyle = "#000000";
                ctx.fillText(x.toString(), x, 10);
            }}
        }}

        for (let y = 0; y <= ctx.canvas.height; y += 25) {{
            ctx.strokeStyle = (y % 50 === 0) ? "#888888" : "#cccccc";
            ctx.beginPath();
            ctx.moveTo(0, y);
            ctx.lineTo(ctx.canvas.width, y);
            ctx.stroke();
            
            if (y % 50 === 0 && y !== 0) {{
                ctx.fillStyle = "#000000";
                ctx.fillText(y.toString(), 5, y + 10);
            }}
        }}
        ctx.restore();
        """
        CanvasContext.js_src += js_code

for prop in CanvasContext.PROPERTIES.keys():
    getter = lambda self, prop=prop: self._get_property(prop)
    setter = lambda self, value, prop=prop: self._set_property(prop, value)
    setattr(CanvasContext, prop, property(getter, setter))
