import Foundation
import AppKit

let fileManager = FileManager.default
let svgFolderURL = URL(fileURLWithPath: "./svg") // Canvia el camí segons calgui
let destinationFolderURL = URL(fileURLWithPath: "./png")
try? FileManager.default.createDirectory(at: destinationFolderURL, withIntermediateDirectories: true)

func convertSVGtoPNG(svgURL: URL, pngURL: URL, scale: CGFloat = 2.0) {
    guard let image = NSImage(contentsOf: svgURL) else { return }
    let size = NSSize(width: image.size.width * scale, height: image.size.height * scale)
    
    let rep = NSBitmapImageRep(bitmapDataPlanes: nil, pixelsWide: Int(size.width), pixelsHigh: Int(size.height), bitsPerSample: 8, samplesPerPixel: 4, hasAlpha: true, isPlanar: false, colorSpaceName: .deviceRGB, bytesPerRow: 0, bitsPerPixel: 0)
    rep?.size = size
    
    NSGraphicsContext.current = NSGraphicsContext(bitmapImageRep: rep!)
    image.draw(in: NSRect(origin: .zero, size: size))
    NSGraphicsContext.current = nil
    
    if let pngData = rep?.representation(using: .png, properties: [:]) {
        try? pngData.write(to: pngURL)
    }
}

do {
    let svgFiles = try fileManager.contentsOfDirectory(at: svgFolderURL, includingPropertiesForKeys: nil, options: .skipsHiddenFiles).filter { $0.pathExtension == "svg" }
    
    for svgFileURL in svgFiles {
        let pngFileURL = destinationFolderURL.appendingPathComponent(svgFileURL.deletingPathExtension().lastPathComponent).appendingPathExtension("png")
        convertSVGtoPNG(svgURL: svgFileURL, pngURL: pngFileURL)
    }
    
    print("Conversió completada!")
} catch {
    print("Error: \(error)")
}
