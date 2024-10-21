// Existing Viewer interface
interface ImageViewer {
    void display(String imageType, String imageName);
}

// New ImageReader interface
interface ImageReader {
    void readJpeg(String fileName);
    void readPng(String fileName);
}

// Implementation of ImageReader for JPEG
class JpegReader implements ImageReader {
    @Override
    public void readJpeg(String fileName) {
        System.out.println("Reading JPEG image. Name: " + fileName);
    }

    @Override
    public void readPng(String fileName) {
        // Do nothing
    }
}

// Implementation of ImageReader for PNG
class PngReader implements ImageReader {
    @Override
    public void readJpeg(String fileName) {
        // Do nothing
    }

    @Override
    public void readPng(String fileName) {
        System.out.println("Reading PNG image. Name: " + fileName);
    }
}

// Adapter class implementing ImageViewer and using ImageReader
class ImageViewerAdapter implements ImageViewer {
    ImageReader imageReader;

    public ImageViewerAdapter(String imageType) {
        if(imageType.equalsIgnoreCase("jpeg")) {
            imageReader = new JpegReader();
        } else if(imageType.equalsIgnoreCase("png")) {
            imageReader = new PngReader();
        }
    }

    @Override
    public void display(String imageType, String imageName) {
        if(imageType.equalsIgnoreCase("jpeg")) {
            imageReader.readJpeg(imageName);
        } else if(imageType.equalsIgnoreCase("png")) {
            imageReader.readPng(imageName);
        }
    }
}

// Implementation of ImageViewer using the adapter
class ImageViewerApplication implements ImageViewer {
    ImageViewerAdapter imageViewerAdapter;

    @Override
    public void display(String imageType, String imageName) {
        // Displaying GIF images directly
        if(imageType.equalsIgnoreCase("gif")) {
            System.out.println("Displaying GIF image. Name: " + imageName);
        }
        // Using adapter for other image formats
        else if(imageType.equalsIgnoreCase("jpeg") || imageType.equalsIgnoreCase("png")) {
            imageViewerAdapter = new ImageViewerAdapter(imageType);
            imageViewerAdapter.display(imageType, imageName);
        } else {
            System.out.println("Invalid image format. " + imageType + " not supported");
        }
    }


// Main class to test the adapter pattern

    public static void main(String[] args) {
        ImageViewerApplication imageViewerApplication = new ImageViewerApplication();

        imageViewerApplication.display("gif", "animation.gif");
        imageViewerApplication.display("jpeg", "photo.jpeg");
        imageViewerApplication.display("png", "logo.png");
        imageViewerApplication.display("bmp", "icon.bmp");
    }
}
