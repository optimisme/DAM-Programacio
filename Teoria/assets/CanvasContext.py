from IPython.display import display, HTML, Javascript

class CanvasContext:

    js_response = None
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

    def addJavaScript(self, js_code):
        CanvasContext.js_src += js_code

    def display(self):
        # print(CanvasContext.js_src) 
        display(Javascript(CanvasContext.js_src))

    def normalizeText(text):
        return "`" + text.replace("`", "\\`") + "`"

    def normalizeNumbers(value):
        if isinstance(value, (int, float)):
            return str(value)
        else:
            return "`" + value.replace("`", "\\`") + "`"

    def _set_property(self, prop_name, value):
        meta = self.PROPERTIES[prop_name]
        if meta["type"] == "string":
            value = CanvasContext.normalizeText(value)
        elif meta["type"] == "number":
            value = CanvasContext.normalizeNumbers(value)

        setattr(self, f"_{prop_name}", value)
        js_code = f"""
        ctx.{prop_name} = {value};
        """
        CanvasContext.js_src += js_code

    def _get_property(self, prop_name):
        return getattr(self, f"_{prop_name}")

    def addVariable(self, destinationVariable, value):
        if isinstance(value, str):
            value = value.replace('`', '\\`')
            value = f'`{value}`'
        js_code = f"""
        var {destinationVariable} = {value};
        """
        CanvasContext.js_src += js_code

    def setVariable(self, destinationVariable, value):
        if isinstance(value, str):
            value = value.replace('`', '\\`')
            value = f'`{value}`'
        js_code = f"""
        {destinationVariable} = {value};
        """
        CanvasContext.js_src += js_code

    def measureText(self, destinatinVariableName, text):
        text_value = CanvasContext.normalizeText(text)
        js_code = f"""
        {destinatinVariableName} = ctx.measureText({text_value});
        """
        CanvasContext.js_src += js_code

    def isPointInPath(self, destinationVariable, x, y):
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        js_code = f"""
        {destinationVariable} = ctx.isPointInPath({x_value} , {y_value});
        """
        CanvasContext.js_src += js_code

    def isPointInStroke(self, destinationVariable, x, y):
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        js_code = f"""
        {destinationVariable} = ctx.isPointInStroke({x_value} , {y_value});
        """
        CanvasContext.js_src += js_code

    def getTransform(self, destinationVariable):
        js_code = f"""
        {destinationVariable} = ctx.getTransform();
        """
        CanvasContext.js_src += js_code

    def getLineDash(self, destinationVariable):
        js_code = f"""
        {destinationVariable} = ctx.getLineDash();
        """
        CanvasContext.js_src += js_code

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
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        ample_value = CanvasContext.normalizeNumbers(ample)
        alt_value = CanvasContext.normalizeNumbers(alt)
        js_code = f"""
        ctx.rect({x_value}, {y_value}, {ample_value}, {alt_value});
        """
        CanvasContext.js_src += js_code

    def fillRect(self, x, y, ample, alt):
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        ample_value = CanvasContext.normalizeNumbers(ample)
        alt_value = CanvasContext.normalizeNumbers(alt)
        js_code = f"""
        ctx.fillRect({x_value}, {y_value}, {ample_value}, {alt_value});
        """
        CanvasContext.js_src += js_code

    def clearRect(self, x, y, ample, alt):
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        ample_value = CanvasContext.normalizeNumbers(ample)
        alt_value = CanvasContext.normalizeNumbers(alt)
        js_code = f"""
        ctx.clearRect({x_value}, {y_value}, {ample_value}, {alt_value});
        """
        CanvasContext.js_src += js_code

    def strokeRect(self, x, y, ample, alt):
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        ample_value = CanvasContext.normalizeNumbers(ample)
        alt_value = CanvasContext.normalizeNumbers(alt)
        js_code = f"""
        ctx.strokeRect({x_value}, {y_value}, {ample_value}, {alt_value});
        """
        CanvasContext.js_src += js_code

    def fillText(self, text, x, y, maxAmple=None):
        text_value = CanvasContext.normalizeText(text)
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        maxA_value = ""
        if (maxAmple):
            maxA_value = CanvasContext.normalizeNumbers(maxAmple)
            maxA_value = f", {maxA_value}"
        js_code = f"""
        ctx.fillText({text_value}, {x_value}, {y_value}{maxA_value});
        """
        CanvasContext.js_src += js_code

    def strokeText(self, text, x, y, maxAmple=None):
        text_value = CanvasContext.normalizeText(text)
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        maxA_value = ""
        if (maxAmple):
            maxA_value = CanvasContext.normalizeNumbers(maxAmple)
            maxA_value = f", {maxA_value}"
        js_code = f"""
        ctx.strokeText({text_value}, {x_value}, {y_value}{maxA_value});
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
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        js_code = f"""
        ctx.moveTo({x_value}, {y_value});
        """
        CanvasContext.js_src += js_code

    def lineTo(self, x, y):
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        js_code = f"""
        ctx.lineTo({x_value}, {y_value});
        """
        CanvasContext.js_src += js_code

    def bezierCurveTo(self, cp1x, cp1y, cp2x, cp2y, x, y):
        cp1x_value = CanvasContext.normalizeNumbers(cp1x)
        cp1y_value = CanvasContext.normalizeNumbers(cp1y)
        cp2x_value = CanvasContext.normalizeNumbers(cp2x)
        cp2y_value = CanvasContext.normalizeNumbers(cp2y)
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        js_code = f"""
        ctx.bezierCurveTo({cp1x_value}, {cp1y_value}, {cp2x_value}, {cp2y_value}, {x_value}, {y_value});
        """
        CanvasContext.js_src += js_code

    def quadraticCurveTo(self, cpx, cpy, x, y):
        cpx_value = CanvasContext.normalizeNumbers(cpx)
        cpy_value = CanvasContext.normalizeNumbers(cpy)
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        js_code = f"""
        ctx.quadraticCurveTo({cpx_value}, {cpy_value}, {x_value}, {y_value});
        """
        CanvasContext.js_src += js_code

    def arc(self, x, y, radius, startAngle, endAngle, anticlockwise=False):
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        radius_value = CanvasContext.normalizeNumbers(radius)
        startAngle_value = CanvasContext.normalizeNumbers(startAngle)
        endAngle_value = CanvasContext.normalizeNumbers(endAngle)
        js_code = f"""
        ctx.arc({x_value}, {y_value}, {radius_value}, {startAngle_value}, {endAngle_value}, {str(anticlockwise).lower()});
        """
        CanvasContext.js_src += js_code

    def arcTo(self, x1, y1, x2, y2, radius):
        x1_value = CanvasContext.normalizeNumbers(x1)
        y1_value = CanvasContext.normalizeNumbers(y1)
        x2_value = CanvasContext.normalizeNumbers(x2)
        y2_value = CanvasContext.normalizeNumbers(y2)
        radius_value = CanvasContext.normalizeNumbers(radius)
        js_code = f"""
        ctx.arcTo({x1_value}, {y1_value}, {x2_value}, {y2_value}, {radius_value});
        """
        CanvasContext.js_src += js_code

    def ellipse(self, x, y, radiusX, radiusY, rotation, startAngle, endAngle, anticlockwise=False):
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        radiusX_value = CanvasContext.normalizeNumbers(radiusX)
        radiusY_value = CanvasContext.normalizeNumbers(radiusY)
        rotation_value = CanvasContext.normalizeNumbers(rotation)
        startAngle_value = CanvasContext.normalizeNumbers(startAngle)
        endAngle_value = CanvasContext.normalizeNumbers(endAngle)
        js_code = f"""
        ctx.ellipse({x_value}, {y_value}, {radiusX_value}, {radiusY_value}, {rotation_value}, {startAngle_value}, {endAngle_value}, {str(anticlockwise).lower()});
        """
        CanvasContext.js_src += js_code

    def roundRect(self, x, y, width, height, radius):
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        width_value = CanvasContext.normalizeNumbers(width)
        height_value = CanvasContext.normalizeNumbers(height)
        radius_value = CanvasContext.normalizeNumbers(radius)
        js_code = f"""
        ctx.roundRect({x_value}, {y_value} , {width_value}, {height_value}, {radius_value});
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
        angle_value = CanvasContext.normalizeNumbers(angle)
        js_code = f"""
        ctx.rotate({angle_value});
        """
        CanvasContext.js_src += js_code

    def scale(self, scaleX, scaleY):
        scaleX_value = CanvasContext.normalizeNumbers(scaleX)
        scaleY_value = CanvasContext.normalizeNumbers(scaleY)
        js_code = f"""
        ctx.scale({scaleX_value}, {scaleY_value});
        """
        CanvasContext.js_src += js_code

    def translate(self, x, y):
        x_value = CanvasContext.normalizeNumbers(x)
        y_value = CanvasContext.normalizeNumbers(y)
        js_code = f"""
        ctx.translate({x_value}, {y_value});
        """
        CanvasContext.js_src += js_code

    def transform(self, a, b, c, d, e, f):
        a_value = CanvasContext.normalizeNumbers(a)
        b_value = CanvasContext.normalizeNumbers(b)
        c_value = CanvasContext.normalizeNumbers(c)
        d_value = CanvasContext.normalizeNumbers(d)
        e_value = CanvasContext.normalizeNumbers(e)
        f_value = CanvasContext.normalizeNumbers(f)
        js_code = f"""
        ctx.transform({a_value}, {b_value}, {c_value}, {d_value}, {e_value}, {f_value});
        """
        CanvasContext.js_src += js_code

    def setTransform(self, a, b, c, d, e, f):
        a_value = CanvasContext.normalizeNumbers(a)
        b_value = CanvasContext.normalizeNumbers(b)
        c_value = CanvasContext.normalizeNumbers(c)
        d_value = CanvasContext.normalizeNumbers(d)
        e_value = CanvasContext.normalizeNumbers(e)
        f_value = CanvasContext.normalizeNumbers(f)
        js_code = f"""
        ctx.setTransform({a_value}, {b_value}, {c_value}, {d_value}, {e_value}, {f_value});
        """
        CanvasContext.js_src += js_code

    def resetTransform(self):
        js_code = f"""
        ctx.resetTransform();
        """
        CanvasContext.js_src += js_code

    def drawImage(self, source, sx, sy, sWidth, sHeight, dx, dy, dWidth, dHeight):
        sx_value = CanvasContext.normalizeNumbers(sx)
        sy_value = CanvasContext.normalizeNumbers(sy)
        sWidth_value = CanvasContext.normalizeNumbers(sWidth)
        sHeight_value = CanvasContext.normalizeNumbers(sHeight)
        dx_value = CanvasContext.normalizeNumbers(dx)
        dy_value = CanvasContext.normalizeNumbers(dy)
        dWidth_value = CanvasContext.normalizeNumbers(dWidth)
        dHeight_value = CanvasContext.normalizeNumbers(dHeight)
        js_code = f"""
        var img = new Image();
        img.src = '{source}';
        img.onload = function() {{
            ctx.drawImage(img, {sx_value}, {sy_value}, {sWidth_value}, {sHeight_value}, {dx_value}, {dy_value}, {dWidth_value}, {dHeight_value});
        }};
        """
        CanvasContext.js_src += js_code

    def putImageData(self, imageData, dx, dy):
        # Aquí, imageData hauria de ser una cadena que representi les dades de la imatge
        dx_value = CanvasContext.normalizeNumbers(dx)
        dy_value = CanvasContext.normalizeNumbers(dy)
        js_code = f"""
        ctx.putImageData({imageData}, {dx_value}, {dy_value});
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
        ctx.lineWidth = 1
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
