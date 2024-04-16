package com.project;

import javax.swing.SwingWorker;

@FunctionalInterface
interface BackgroundTask {
    void execute() throws Exception;
}

public class UtilsSwingThread {

    static public void run(BackgroundTask backgroundTask) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Executa la tasca de fons.
                backgroundTask.execute();
                return null;
            }
            
            @Override
            protected void done() {
                try {
                    get(); // Recull el retorn 'Void' de l'execució en anterior
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        worker.execute();
    }
}
